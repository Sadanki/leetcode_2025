public class Solution {
    public string MostCommonWord(string paragraph, string[] banned) {
        char[] delimiters = new char[] { '!', '?', '\'', ',', ';', '.', ' '};
        string[] words = paragraph
            .ToLower()
            .Split(delimiters, StringSplitOptions.RemoveEmptyEntries);

            HashSet<string> bannedSet = new HashSet<string>(banned);
            Dictionary<string, int> freq = new Dictionary<string, int>();

            string mostCommon = "";
            int maxCount =0;

            foreach(string word in words){
                if(bannedSet.Contains(word)) continue;
                if(!freq.ContainsKey(word)){
                    freq[word]=0;
                }
                freq[word]++;

                if(freq[word]> maxCount){
                    maxCount = freq[word];
                    mostCommon= word;
                }
            }

            return mostCommon;
    }
}