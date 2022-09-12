package leetcode.one.zero.nine.four;

class Solution {
    class Trip {
        int numPassengers;
        int from;
        int to;
        
        Trip(int[] trip) {
            this.numPassengers = trip[0];
            this.from = trip[1];
            this.to = trip[2];
        }
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        int[] t = new int[1001];
        for (int[] trip: trips) {
            Trip x = new Trip(trip);
            t[x.from] += x.numPassengers;
            t[x.to] -= x.numPassengers;   
        }
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
