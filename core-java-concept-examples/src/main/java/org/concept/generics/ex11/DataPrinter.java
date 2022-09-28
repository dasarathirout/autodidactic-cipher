package org.concept.generics.ex11;

// T = TYPE
public class DataPrinter<UserType> {
    UserType userData;

    public DataPrinter(UserType userData) {
        this.userData = userData;
    }

    public void printData() {
        System.out.println(userData.getClass().getName() + " > " + userData);
    }
}
