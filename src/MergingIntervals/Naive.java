package MergingIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Naive {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Interval> intervalList = new ArrayList<>(n);
        while ((n--) > 0) {
            intervalList.add(new Interval(in.nextInt(), in.nextInt()));
        }
        List<Interval> result = mergeIntervals(intervalList);
        for (Interval aResult : result) {
            System.out.printf("[%d,%d]%n", aResult.getStart(), aResult.getEnd());
        }
    }

    private static List<Interval> mergeIntervals(List<Interval> intervalList) {
        intervalList.sort((o1, o2) -> o1.getStart() < o2.getStart() ? -1 : 1);
        List<Interval> result = new ArrayList<>();
        result.add(new Interval(intervalList.get(0).getStart(), intervalList.get(0).getEnd()));
        int index = 0;
        for (int i = 1; i < intervalList.size(); i++) {
            Interval current = intervalList.get(i);
            int start = current.getStart();
            int end = current.getEnd();
            Interval previous = result.get(index);
            if (previous.getEnd() >= start) {
                result.set(index, new Interval(previous.getStart(), end));
            } else {
                result.add(new Interval(start, end));
                index++;
            }
        }
        return result;
    }
}
