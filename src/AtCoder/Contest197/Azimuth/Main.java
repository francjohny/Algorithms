package AtCoder.Contest197.Azimuth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x0 = scanner.nextInt(), y0 = scanner.nextInt();
        double xn2 = scanner.nextInt(), yn2 = scanner.nextInt();
        double midx = (xn2 - x0) / 2 + x0, midy = (yn2 - y0) / 2 + y0;
        double r = Math.sqrt(Math.pow(midx - x0, 2) + Math.pow(midy - y0, 2));
        double azimuthX0FromMid = Math.atan2(y0 - midy, x0 - midx);
        double azimuthX1FromMid = azimuthX0FromMid + 2 * Math.PI / n;
        System.out.println((midx + r * Math.cos(azimuthX1FromMid)) + " " + (midy + r * Math.sin(azimuthX1FromMid)));
    }
}
