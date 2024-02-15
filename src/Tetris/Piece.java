package Tetris;

import java.util.*;

public class Piece {
    private Point[] body;
    private int[] skirt;
    private int width;
    private int height;

    public Point[] getBody() {
        return body;
    }

    public int[] getSkirt() {
        return skirt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static final String[] Q = {"0,0", "0,1", "1,0", "1,1"};
    public static final String[] Z = {"0,1", "1,0", "1,1", "2,0"};
    public static final String[] S = {"0,0", "1,0", "1,1", "2,1"};
    public static final String[] T = {"0,1", "1,0", "1,1", "2,1"};
    public static final String[] I = {"0,0", "1,0", "2,0", "3,0"};
    public static final String[] L = {"0,0", "0,1", "0,2", "1,0"};
    public static final String[] J = {"0,0", "1,0", "1,1", "1,2"};

    public Piece(Point[] points) {
        Arrays.sort(points);
        this.body = points;

        int width = 0;
        int height = 0;
        for (Point point : points) {
            if (width <= point.x) width = point.x + 1;
            if (height <= point.y) height = point.y + 1;
        }
        this.width = width;
        this.height = height;

        int[] skirt = new int[width];
        Arrays.fill(skirt, height);
        for (Point point : points)
            if (skirt[point.x] > point.y)
                skirt[point.x] = Math.min(skirt[point.x], point.y);
        this.skirt = skirt;
    }

    public Piece(String[] piece) {
        this(parsePoints(piece));
    }

    private static Point[] parsePoints(String[] piece) {
        List<Point> points = new ArrayList<>();
        for (String point : piece) {
            String[] coordinates = point.split(",");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            points.add(new Point(x, y));
        }
        return points.toArray(new Point[0]);
    }
}
