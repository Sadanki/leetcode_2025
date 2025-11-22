import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store k largest elements
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // remove smallest
            }
        }
        
        return heap.peek(); // root is kth largest
    }
}