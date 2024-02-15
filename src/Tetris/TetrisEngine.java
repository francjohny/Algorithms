package Tetris;

import java.io.*;

public class TetrisEngine {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;

    public static void main(String[] args) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src/Tetris/output.txt"), "utf-8"));
             BufferedReader br = new BufferedReader(new FileReader("src/Tetris/input.txt"))) {
            String input = br.readLine();
            while (input != null) {
                Board board = new Board(WIDTH, HEIGHT);
                writer.write(input + "=>" + getMaxGridHeight(input, board) + "\n");
                input = br.readLine();
            }
        }
    }

    public static int getMaxGridHeight(String input, Board board) {
        String[] moves = input.split(",");
        for (String move : moves) {
            Piece piece = new Piece(board.getPieces().get(move.substring(0, 1)));
            int x = Integer.parseInt(move.substring(1));
            if (board.place(piece, x) == Board.PLACE_ROW_FILLED) {
                board.clearRows();
            }
        }
        return board.getMaxGridHeight();
    }
}
