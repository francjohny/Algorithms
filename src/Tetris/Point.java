package Tetris;

public class Point implements Comparable<Object> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Point pt)) return false;
        return (x == pt.x && y == pt.y);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Object o) {
        Point pt = (Point) o;
        if (this.equals(pt))
            return 0;
        else if (x > pt.x)
            return 1;
        else if (x < pt.x)
            return -1;
        else if (y > pt.y)
            return 1;
        else
            return -1;
    }
}
