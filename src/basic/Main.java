package basic;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        Operation operation = new Operation();


        System.out.println(operation.getResult(expression));
        in.close();
    }
}
