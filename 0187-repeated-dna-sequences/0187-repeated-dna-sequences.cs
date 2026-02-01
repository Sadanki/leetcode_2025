    public class Solution {
        public IList<string> FindRepeatedDnaSequences(string s) {
          int n = s.Length;

          HashSet<string> seen = new HashSet<string>();
          HashSet<string> repeated = new HashSet<string>();

            for(int i =0; i+10<=n; i++){
                string sub = s.Substring(i, 10);
                if(!seen.Add(sub)){
                    repeated.Add(sub);
                }
            }  
            return repeated.ToList();
        }
    }