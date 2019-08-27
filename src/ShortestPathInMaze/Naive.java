package ShortestPathInMaze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        char a[][] = new char[N][M];
        String str[] = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = scanner.next();
            for (int j = 0; j < M; j++) {
                a[i][j] = str[i].charAt(j);
            }
        }
        System.out.println(new Naive().calculateShortestPath(a, N, M));
    }

    private int calculateShortestPath(char[][] a, int N, int M) {
        Cell source = new Cell();
        boolean visited[][] = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = a[i][j] == '1';

                if (a[i][j] == 'S') {
                    source.row = i;
                    source.col = j;
                }
            }
        }

        // perform BFS to find the shortest path
        Queue<Cell> queue = new LinkedList<>();
        queue.add(source);
        visited[source.row][source.col] = true;
        while (!queue.isEmpty()) {
            Cell elem = queue.peek();
            queue.poll();

            if (a[elem.row][elem.col] == 'G')
                return elem.dist;

            // traversing up
            if (elem.row - 1 >= 0 && !visited[elem.row - 1][elem.col]) {
                queue.add(new Cell(elem.row - 1, elem.col, elem.dist + 1));
                visited[elem.row - 1][elem.col] = true;
            }

            // traversing down
            if (elem.row + 1 < N && !visited[elem.row + 1][elem.col]) {
                queue.add(new Cell(elem.row + 1, elem.col, elem.dist + 1));
                visited[elem.row + 1][elem.col] = true;
            }

            // traversing left
            if (elem.col - 1 >= 0 && !visited[elem.row][elem.col - 1]) {
                queue.add(new Cell(elem.row, elem.col - 1, elem.dist + 1));
                visited[elem.row][elem.col - 1] = true;
            }

            // traversing right
            if (elem.col + 1 < M && !visited[elem.row][elem.col + 1]) {
                queue.add(new Cell(elem.row, elem.col + 1, elem.dist + 1));
                visited[elem.row][elem.col + 1] = true;
            }
        }
        return -1;
    }

    class Cell {
        int row;
        int col;
        int dist;

        Cell() {
        }

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
