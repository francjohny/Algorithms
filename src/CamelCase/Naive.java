package CamelCase;

import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int length = s.split("[A-Z]").length;
        System.out.println(length);
    }
}

