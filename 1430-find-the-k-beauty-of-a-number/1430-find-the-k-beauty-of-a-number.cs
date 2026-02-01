public class Solution {
    public int DivisorSubstrings(int num, int k) {
        string s = num.ToString();
        int n = s.Length;
        int count =0;

        for(int i = 0; i+k<=n ; i++){
            string sub = s.Substring(i, k);
            int val = int.Parse(sub);

            if (val != 0 && num % val == 0){
                count++;
            }
        }
        return count;
    }
}