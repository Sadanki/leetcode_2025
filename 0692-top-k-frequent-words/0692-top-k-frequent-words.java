import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // Step 2: Min-heap with custom comparator
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int f1 = freqMap.get(w1);
            int f2 = freqMap.get(w2);
            if (f1 == f2) {
                return w2.compareTo(w1); // reverse lex order for equal frequency
            }
            return f1 - f2; // lower frequency first
        });
        
        // Step 3: Keep top k elements in heap
        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // remove smallest
            }
        }
        
        // Step 4: Build result list
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        
        Collections.reverse(result); // since heap gives smallest first
        return result;
    }
}
