package org.concept.functional.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneValid(String phone) {
        return phone.startsWith("+91");
    }

    private boolean isAdult(LocalDate dob) {
        int adultAge = 18;
        return Period.between(dob, LocalDate.now()).
                getYears() > adultAge;
    }

    public boolean isValidCustomer(Customer customer) {
        return isEmailValid(customer.getEmail())
                && isPhoneValid(customer.getPhone())
                && isAdult(customer.getDOB());
    }
}

enum ValidationStatus {
    SUCCESS,
    EMAIL_ERROR,
    PHONE_ERROR,
    NOT_ADULT;
}