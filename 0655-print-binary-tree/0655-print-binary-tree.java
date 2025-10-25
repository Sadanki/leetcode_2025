class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int m = height + 1;
        int n = (int) Math.pow(2, m) - 1;

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(n, ""));
            res.add(row);
        }

        fill(res, root, 0, 0, n - 1, height);
        return res;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void fill(List<List<String>> res, TreeNode node, int row, int left, int right, int height) {
        if (node == null || row > height) return;

        int mid = (left + right) / 2;
        res.get(row).set(mid, Integer.toString(node.val));

        fill(res, node.left, row + 1, left, mid - 1, height);
        fill(res, node.right, row + 1, mid + 1, right, height);
    }
}