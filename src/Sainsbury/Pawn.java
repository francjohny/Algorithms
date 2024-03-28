package Sainsbury;

public class Pawn {
    public static void main(String[] args) {
        System.out.println(run("2b", 3, 2));
        System.out.println(calculateFinalPosition("2b", 3, 2));
        System.out.println(run("5h", 11, 25));
        System.out.println(calculateFinalPosition("5h", 11, 25));
        System.out.println(run("6h", 2, 1));
        System.out.println(calculateFinalPosition("6h", 2, 1));
        System.out.println(run("8h", 2, 1));
        System.out.println(calculateFinalPosition("8h", 2, 1));
    }

    public static String run(String startPosition, int dy, int dx) {
        dy %= 8;
        dx %= 8;
        char[] xz = new char[]{'a','b','c','d','e','f','g','h'};
        char[] yz = new char[]{'1','2','3','4','5','6','7','8'};
        int y = startPosition.charAt(0) - '1';
        int x = startPosition.charAt(1) - 'a';
        int newX = (x + dx) % 8;
        int newY = (y + dy) % 8;
        int nextPos = newX + 8 * newY;
        assert newY == nextPos / 8;
        assert newX == nextPos % 8;
        return yz[newY] + "" + xz[newX];
    }

    private static String calculateFinalPosition(String startPosition, int up, int right) {
        int currentRow = Character.getNumericValue(startPosition.charAt(0));
        char currentColumn = startPosition.charAt(1);

        // Calculate final row and column
        int finalRow = (currentRow + up - 1) % 8 + 1;
        char finalColumn = (char) ((currentColumn - 'a' + right) % 8 + 'a');

        return finalRow + "" + finalColumn;
    }
}
