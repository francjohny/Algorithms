package leetcode.nine.seven.three;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    
    private int calcDistance(int x1, int y1) {
        return x1 * x1 + y1 * y1;
    }
    
    class Point {
        int x;
        int y;
        
        Point() {}
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> set = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return - calcDistance(p1.x, p1.y) + calcDistance(p2.x, p2.y);
            }
        });
        for (int[] point: points) {
            int x = point[0], y = point[1];
            set.offer(new Point(x, y));
            if (set.size() > k)
                set.poll();
        }

        int n = points.length;
        int m = points[0].length;
        int[][] output = new int[k][2];
        int count = 0;
        while(k > 0) {
            Point p = set.poll();
            output[--k] = new int[]{p.x, p.y};
        }
        return output;
            
    }
}
