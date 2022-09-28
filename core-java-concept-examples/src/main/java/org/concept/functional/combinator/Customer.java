package org.concept.functional.combinator;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String phone;
    private final LocalDate DOB;

    public Customer(String name,
                    String email,
                    String phone,
                    LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.DOB = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    @Override
    public String toString() {
        final StringBuilder values = new StringBuilder("Customer{ ");
        values.append(getName() + ", ");
        values.append(getEmail() + ", ");
        values.append(getPhone() + ", ");
        values.append(getDOB());
        values.append(" }");
        return values.toString();
    }
}
