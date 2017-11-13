package JavaMD5;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5"); // SHA-256
            md5.update(string.getBytes());
            String hexBinary = DatatypeConverter.printHexBinary(md5.digest()).toLowerCase();
            System.out.println(hexBinary);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
