package org.concept.functional.combinator;

import java.time.LocalDate;

public class MainCustomer {
    public static void main(String[] arguments) {
        Customer customer = new Customer(
                "R.Dasarathi",
                "drout@email.com",
                "+91-9976600300",
                LocalDate.of(2020, 1, 1)
        );
        CustomerValidatorService validatorService = new CustomerValidatorService();
        System.out.println(validatorService.isValidCustomer(customer) + " | " + customer);
        ValidationStatus status = CustomerRegistrationValidator.isEmailValid().
                and(CustomerRegistrationValidator.isPhoneValid()).
                and(CustomerRegistrationValidator.isAdultValid()).apply(customer);
        System.out.println(status+" | "+customer);
    }
}
