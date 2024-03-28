package HackerRank.TruckTour;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int n = petrolpumps.size();
        int[] fuel = new int[n];
        int[][] pp = new int[n][2];
        for(int i = 0; i < n; i++) {
            List<Integer> pump = petrolpumps.get(i);
            pp[i][0] = pump.get(0);
            pp[i][1] = pump.get(1);
            fuel[i] = pp[i][0] - pp[i][1];
        }
        int index = 0, total = 0;
        for (int i = 0; i <  n; i++) {
            total += fuel[i];
            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }
        return index;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                List<Integer> list = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                petrolpumps.add(list);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
