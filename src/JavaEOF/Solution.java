package JavaEOF;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 1;
        while(in.hasNext()) {
            System.out.println(count++ + " " + in.nextLine());
        }
    }
}
