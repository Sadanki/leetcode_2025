import java.util.*;

class MyCalendar {
    private List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] e : events) {
            int s = e[0], t = e[1];
            // overlap check
            if (startTime < t && s < endTime) {
                return false;
            }
        }
        events.add(new int[]{startTime, endTime});
        return true;
    }
}