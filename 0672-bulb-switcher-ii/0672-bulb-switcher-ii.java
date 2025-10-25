class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n > 6) n = 6; // Only first 6 bulbs matter due to pattern repetition

        Set<String> seen = new HashSet<>();
        for (int b1 = 0; b1 <= 1; b1++) {
            for (int b2 = 0; b2 <= 1; b2++) {
                for (int b3 = 0; b3 <= 1; b3++) {
                    for (int b4 = 0; b4 <= 1; b4++) {
                        int total = b1 + b2 + b3 + b4;
                        if (total % 2 == presses % 2 && total <= presses) {
                            boolean[] bulbs = new boolean[n];
                            Arrays.fill(bulbs, true); // All bulbs initially ON

                            for (int i = 0; i < n; i++) {
                                int label = i + 1;
                                if (b1 == 1) bulbs[i] = !bulbs[i];
                                if (b2 == 1 && label % 2 == 0) bulbs[i] = !bulbs[i];
                                if (b3 == 1 && label % 2 == 1) bulbs[i] = !bulbs[i];
                                if (b4 == 1 && (label - 1) % 3 == 0) bulbs[i] = !bulbs[i];
                            }

                            StringBuilder sb = new StringBuilder();
                            for (boolean bulb : bulbs) sb.append(bulb ? '1' : '0');
                            seen.add(sb.toString());
                        }
                    }
                }
            }
        }
        return seen.size();
    }
}