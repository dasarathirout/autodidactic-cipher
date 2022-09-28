package org.concept.generics.ex11;

public class PrinterInteger {
    private Integer data;

    public PrinterInteger(Integer data) {
        this.data = data;
    }

    public void printContent() {
        System.out.println(PrinterInteger.class.getName() + " => " + data);
    }
}
