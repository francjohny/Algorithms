package StrangeCounter;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Scanner;

public class Faster {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number = in.nextLong();
        long upperLimit, diff;
        for (upperLimit = 0, diff = 3; upperLimit < number; upperLimit += diff, diff *= 2) ;
        long windowSize = (upperLimit + 3) / 2;
        System.out.println(2 * windowSize - number - 2);
    }
}
