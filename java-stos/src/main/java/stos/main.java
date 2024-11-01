package stos;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            String[] elements = input.split(" ");
            Rpn rpn =  new Rpn(elements);
            rpn.stackHandling();
        }
        finally {
            scanner.close();
        }
    }
}