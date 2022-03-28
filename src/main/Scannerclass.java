package main;

import java.util.Scanner;

public class Scannerclass {
    Scanner sc = new Scanner(System.in);

    public String ReadData(String s) {
        String data = "";
        System.out.println("\n" + s);
        data = sc.nextLine();
        return data;
    }
}
