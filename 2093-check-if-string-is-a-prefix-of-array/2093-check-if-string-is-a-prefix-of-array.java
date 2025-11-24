class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder prefix = new StringBuilder();
        
        for (String w : words) {
            prefix.append(w);
            if (prefix.toString().equals(s)) {
                return true;
            }
            if (prefix.length() > s.length()) {
                return false;
            }
        }
        
        return false;
    }
}