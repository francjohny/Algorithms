package JavaMD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Naive {
    public static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "x", bi);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5"); // SHA-256
            md5.update(string.getBytes());
            String hexBinary = toHex(md5.digest());
            System.out.println(hexBinary);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
