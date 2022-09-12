package leetcode.two.nine.five;

import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (minHeap.size() < maxHeap.size())
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        return minHeap.size() > maxHeap.size()
               ? minHeap.peek()
               : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
