public class Solution {
    public int CountGoodSubstrings(string s) {
      int n = s.Length;
      int count = 0;

      for(int i = 0; i+2<n ; i++){
        HashSet<char> set = new HashSet<char>();
        set.Add(s[i]);
        set.Add(s[i+1]);
        set.Add(s[i+2]);

        if(set.Count == 3){
            count++;
        }
      }  
      return count;
    }
}