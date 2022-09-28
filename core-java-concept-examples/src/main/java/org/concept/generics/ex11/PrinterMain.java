package org.concept.generics.ex11;

public class PrinterMain {
    public static void main(String[] arrays) {
        showDataContent();
        showDataContentGenericV1();
        showDataContentGenericV2();
    }

    public static void showDataContent() {
        PrinterInteger integerObject = new PrinterInteger(1234);
        PrinterString stringObject = new PrinterString("DATA DATA");
        PrinterBoolean booleanObject = new PrinterBoolean(true);

        integerObject.printContent();
        stringObject.printContent();
        booleanObject.printContent();
    }

    public static void showDataContentGenericV1() {
        DataPrinter<Integer> integerObject = new DataPrinter<>(112233);
        DataPrinter<String> stringObject = new DataPrinter<>("USER VALUE");
        DataPrinter<Boolean> booleanObject = new DataPrinter<>(false);
        integerObject.printData();
        stringObject.printData();
        booleanObject.printData();
    }

    public static void showDataContentGenericV2() {
        DataPrinter<PrinterInteger> integerObject = new DataPrinter<>(new PrinterInteger(9988));
        DataPrinter<PrinterString> stringObject = new DataPrinter<>(new PrinterString("USER VALUE"));
        DataPrinter<PrinterBoolean> booleanObject = new DataPrinter<>(new PrinterBoolean(false));
        integerObject.printData();
        stringObject.printData();
        booleanObject.printData();
    }
}
