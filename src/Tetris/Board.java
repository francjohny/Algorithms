package Tetris;

import java.util.*;

public class Board {
    private int width;
    private int height;
    private boolean[][] grid;
    private int[] heights;
    private int[] widths;

    private int maxGridHeight;

    public Map<String, String[]> pieces;
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        heights = new int[width];
        widths = new int[height];
        maxGridHeight = 0;
        pieces = new HashMap<>();
        pieces.put("Q", Piece.Q);
        pieces.put("Z", Piece.Z);
        pieces.put("S", Piece.S);
        pieces.put("T", Piece.T);
        pieces.put("I", Piece.I);
        pieces.put("L", Piece.L);
        pieces.put("J", Piece.J);
    }

    public int getMaxGridHeight() {
        return maxGridHeight;
    }

    public Map<String, String[]> getPieces() {
        return pieces;
    }

    public int getOriginHeight(Piece piece, int x) {
        int y = 0;
        for (int i = 0; i < piece.getWidth(); i++) {
            int y1 = heights[i + x] - piece.getSkirt()[i];
            if (y1 > 0 && y < y1) {
                y = y1;
            }
        }
        return y;
    }

    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    public int place(Piece piece, int x) {
        int y = getOriginHeight(piece, x);
        int result = PLACE_OK;
        for(Point point: piece.getBody()) {
            int newX = x + point.x;
            int newY = y + point.y;
            if (grid[newX][newY]) {
                result = PLACE_BAD;
            } else if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
                result = PLACE_OUT_BOUNDS;
            }else {
                grid[newX][newY] = true;
                heights[newX] = newY + 1;
                if (heights[newX] > maxGridHeight) {
                    maxGridHeight = heights[newX];
                }
                widths[newY]++;
                if (widths[newY] == width) {
                    result = PLACE_ROW_FILLED;
                }
            }
        }
        return result;
    }

    public void clearRows() {
        boolean[][] result = new boolean[width][height];
        List<Integer> xWidths = new ArrayList<>();
        int clearedRows = 0;
        for (int i = 0; i < maxGridHeight; i++) {
            if (widths[i] != width) {
                for (int j = 0; j < width; j++) {
                    result[j][i] = grid[j][i];
                }
            } else {
                clearedRows++;
            }
        }
        for (int i = 0; i < width; i++) {
            heights[i] -= clearedRows;
        }
        for (int i = 0; i < maxGridHeight; i++) {
            if (widths[i] != width) {
                xWidths.add(widths[i]);
            }
        }
        widths = new int[height];
        int c=0;
        for (int w: xWidths) {
            widths[c++] = w;
        }
        maxGridHeight = Arrays.stream(heights).max().getAsInt();
        grid = result;
    }
}
