class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // root at index 0

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue(); // leftmost index
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue() - minIndex; // normalize to avoid overflow

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    queue.offer(new Pair<>(node.left, 2 * index));
                if (node.right != null)
                    queue.offer(new Pair<>(node.right, 2 * index + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}