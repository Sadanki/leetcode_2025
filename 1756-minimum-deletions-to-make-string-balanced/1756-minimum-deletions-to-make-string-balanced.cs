public class Solution {
    public int MinimumDeletions(string s) {
       int deletion =0;
       int countB =0;
       foreach(char c in s){
        if(c=='a'){
            deletion = Math.Min(deletion+1, countB);
        }else{
            countB++;
        }
       } 
       return deletion;
    }
}