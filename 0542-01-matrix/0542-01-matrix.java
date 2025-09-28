class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;           // Number of rows
        int n = mat[0].length;        // Number of columns

        int[][] dist = new int[m][n]; // Distance matrix to store result
        Queue<int[]> q = new LinkedList<>(); // Queue to perform BFS. Each element is int[]{row, col}

        // Step 1: Initialize the queue with all 0s and set their distance to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // ✅ You asked: Why do we add all 0s to the queue?
                // Because we want to start BFS from all 0s simultaneously (multi-source BFS)
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;               // Distance to itself is 0
                    q.offer(new int[]{i, j});     // Add coordinates of 0 to the queue
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // ✅ You asked: What is Integer.MAX_VALUE?
                    // It's the largest possible int value, used here to represent "infinity"
                    // Meaning: we haven't reached this cell yet
                }
            }
        }

        // ✅ You asked: What is dirs and why do we use it?
        // It's a direction array to move in 4 directions: down, up, right, left
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
            int[] cell = q.poll(); // ✅ You asked: What does q.poll() do?
            // It removes and returns the front element from the queue (FIFO)
            int r = cell[0], c = cell[1]; // Current cell coordinates

            // ✅ You asked: What does this loop do?
            // It explores all 4 neighbors of the current cell
            for (int[] d : dirs) {
                int nr = r + d[0]; // New row
                int nc = c + d[1]; // New column

                // ✅ You asked: Why check bounds here?
                // To make sure the neighbor is inside the matrix
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    // ✅ You asked: Why check dist[nr][nc] > dist[r][c] + 1?
                    // To see if we found a shorter path to the neighbor
                    // ✅ You asked: What does +1 mean?
                    // It means moving from current cell to neighbor takes 1 step
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1; // Update distance
                        q.offer(new int[]{nr, nc});   // Add neighbor to queue to continue BFS
                    }
                }
            }
        }

        // ✅ You asked: What does the final matrix look like?
        // It contains the shortest distance from each cell to the nearest 0
        return dist;
    }
}