import java.util.*; 

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Create a dynamic list to hold the current row
        List<Integer> row = new ArrayList<>();
        
        // Base case: first row of Pascal's Triangle is always [1]
        row.add(1); 
        
        // Loop to build each row from 1 to rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            
            // Update the row in reverse to avoid overwriting values
            // Each element becomes: row[j] = row[j] + row[j - 1]
            for (int j = i - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            
            // Append 1 at the end of the row (every row ends with 1)
            row.add(1); 
        }
        
        // Return the final row after all iterations
        return row;
    }
}