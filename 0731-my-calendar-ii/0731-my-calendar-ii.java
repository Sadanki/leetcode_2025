import java.util.*;

class MyCalendarTwo {
    private List<int[]> events;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // Step 1: check against overlaps (double bookings)
        for (int[] o : overlaps) {
            if (startTime < o[1] && endTime > o[0]) {
                // overlap with a double booking → triple booking
                return false;
            }
        }
        
        // Step 2: record new overlaps with existing events
        for (int[] e : events) {
            if (startTime < e[1] && endTime > e[0]) {
                // overlap region
                overlaps.add(new int[]{
                    Math.max(startTime, e[0]),
                    Math.min(endTime, e[1])
                });
            }
        }
        
        // Step 3: add event
        events.add(new int[]{startTime, endTime});
        return true;
    }
}