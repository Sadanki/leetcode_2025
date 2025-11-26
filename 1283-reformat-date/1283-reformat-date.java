import java.util.*;

class Solution {
    public String reformatDate(String date) {
        // Step 1: Split into parts
        String[] parts = date.split(" ");
        String dayPart = parts[0];
        String monthPart = parts[1];
        String yearPart = parts[2];
        
        // Step 2: Process day (remove suffix and pad)
        String day = dayPart.replaceAll("[a-z]+", "");
        if (day.length() == 1) day = "0" + day;
        
        // Step 3: Map month abbreviation to number
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        
        String month = months.get(monthPart);
        
        // Step 4: Build result
        return yearPart + "-" + month + "-" + day;
    }
}