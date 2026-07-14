class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        if (q.isEmpty() || q.size() == n * n) {
            return -1;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int level = -1;

        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            
            for(int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i = 0; i < 4; i++) {
                    int R = r + dr[i];
                    int C = c + dc[i];

                    if(R < 0 || C < 0 || R >= n || C >= n || grid[R][C] != 0) {
                        continue;
                    }

                    grid[R][C] = 1;
                    q.offer(new int[] {R, C});
                }
            }
        }

        return level;
    }
}