public class Solution {
    public int UniqueMorseRepresentations(string[] words) {
        string[] morse = new string[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> trasnformations = new HashSet<String>();

        foreach(string word in words){
            StringBuilder sb = new StringBuilder();
            foreach(char c in word){
                sb.Append(morse[c-'a']);
            }
            trasnformations.Add(sb.ToString());
        }
        return trasnformations.Count;
    }
}