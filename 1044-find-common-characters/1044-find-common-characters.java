class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        for (char c : words[0].toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] tempFreq = new int[26];
            for (char c : words[i].toCharArray()) {
                tempFreq[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                freq[j] = Math.min(freq[j], tempFreq[j]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;

    }
}