package org.concept.functional.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationStatus> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? ValidationStatus.SUCCESS : ValidationStatus.EMAIL_ERROR;
    }

    static CustomerRegistrationValidator isPhoneValid() {
        return customer -> customer.getPhone().startsWith("+91") ? ValidationStatus.SUCCESS : ValidationStatus.PHONE_ERROR;
    }

    static CustomerRegistrationValidator isAdultValid() {
        return customer -> Period.between(customer.getDOB(), LocalDate.now()).
                getYears() > 18 ? ValidationStatus.SUCCESS : ValidationStatus.NOT_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator otherService) {
        return customer -> {
            ValidationStatus status = this.apply(customer);
            return status.equals(ValidationStatus.SUCCESS) ? otherService.apply(customer) : status;
        };
    }
}
