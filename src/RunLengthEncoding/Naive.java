package RunLengthEncoding;

import java.util.Scanner;

public class Naive {

    private static String encode(String source) {
        StringBuilder dest = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while(i + 1 < source.length() && source.charAt(i + 1) == source.charAt(i))
            {
                runLength++;
                i++;
            }

            dest.append(source.charAt(i));
            dest.append(runLength);
        }
        return dest.toString();
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(encode(s));

    }
}
