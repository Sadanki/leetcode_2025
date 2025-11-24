class Solution {
    public int countPoints(String rings) {
        Set<Character> [] rods= new HashSet[10];
        for(int i=0; i<10; i++){
            rods[i]= new HashSet<>();
        }

        for(int i=0; i< rings.length(); i=i+2){
            char color = rings.charAt(i);
            int rod=rings.charAt(i+1)-'0';
            rods[rod].add(color);
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (rods[i].size() == 3) {
                count++;
            }
        }
        
        return count;



    }
}