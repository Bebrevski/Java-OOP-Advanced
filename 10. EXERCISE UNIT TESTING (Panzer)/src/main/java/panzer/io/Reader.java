package panzer.io;

import panzer.contracts.InputReader;

import java.util.Scanner;

public class Reader implements InputReader {
    private Scanner skener;

    public Reader() {
        this.skener =new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return skener.nextLine();
    }
}
