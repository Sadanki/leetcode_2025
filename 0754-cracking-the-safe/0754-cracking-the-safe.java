class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        StringBuilder start = new StringBuilder();

        for(int i=0; i<n-1 ; i++) start.append('0');
        String node = start.toString();
        dfs(node, visited, sb, k, n);
        sb.append(node);
        return sb.toString();
    }

    private void dfs( String node, Set<String> visited, StringBuilder sb, int k, int n){
        for(int i =0; i<k; i++){
            String next = node+i;
            if(!visited.contains(next)){
                visited.add(next);
                dfs(next.substring(1), visited,sb,k, n);
                sb.append(i);
            }
        }
    }
}