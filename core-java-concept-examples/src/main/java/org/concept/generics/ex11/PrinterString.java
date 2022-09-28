package org.concept.generics.ex11;

public class PrinterString {
    private String data;

    public PrinterString(String data) {
        this.data = data;
    }

    public void printContent() {
        System.out.println(PrinterString.class.getName()+" => "+data);
    }
}
