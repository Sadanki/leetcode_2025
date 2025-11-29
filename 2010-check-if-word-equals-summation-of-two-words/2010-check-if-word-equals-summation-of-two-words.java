class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getValue(firstWord) + getValue(secondWord) == getValue(targetWord);
    }
    
    private int getValue(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c - 'a'); // letter value
        }
        return Integer.parseInt(sb.toString());
    }
}