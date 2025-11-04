class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (mapST.containsKey(sc)) {
                if (mapST.get(sc) != tc) return false; // inconsistent mapping
            } else {
                if (mappedChars.contains(tc)) return false; // duplicate target
                mapST.put(sc, tc);
                mappedChars.add(tc);
            }
        }

        return true;
    }
}