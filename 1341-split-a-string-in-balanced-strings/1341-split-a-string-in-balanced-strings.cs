public class Solution {
    public int BalancedStringSplit(string s) {
     int balance =0, count =0;

     for(int i =0; i<s.Length; i++){
        if(s[i]== 'R')
            balance++;
            else
            balance--;
            if(balance == 0)
            count++;
     }  
     return count;

    }
}