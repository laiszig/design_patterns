package interface_segregation_principle;

/*
Recommendation on how to split interfaces into smaller interfaces
You shouldn't put in our interfaces more than our client is expecting to implement
*/

import javax.print.Doc;

public class Document {

}

interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {
        //meaningful code
    }

    @Override
    public void fax(Document d) {
        // ?
        // throw exception?
        // these methods are not being used.
        // what if I don't control the machine?
        // I don't own the source code.
    }

    @Override
    public void scan(Document d) {
        // ?
    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

// YAGNI - You ain't going to need it.

class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {
        //meaningful code
    }
}

class Photocopier implements Printer, Scanner {

    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner{}

class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}

