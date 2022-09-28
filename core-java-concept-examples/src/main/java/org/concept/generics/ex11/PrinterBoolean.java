package org.concept.generics.ex11;

public class PrinterBoolean {
    private Boolean data;

    public PrinterBoolean(Boolean data) {
        this.data = data;
    }

    public void printContent() {
        System.out.println(PrinterBoolean.class.getName() +" => "+ data);
    }
}
