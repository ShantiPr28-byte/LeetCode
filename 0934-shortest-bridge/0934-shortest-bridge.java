class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();

        boolean found = false;
        for(int i = 0; i < n && !found; i++) {
            for(int j = 0; j < n && !found; j++) {
                if(grid[i][j] == 1) {
                    dfs(i, j, grid, q);
                    found = true;
                }
            }
        }

        int flip = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i = 0; i < 4; i++) {
                    int R = r + dr[i];
                    int C = c + dc[i];

                    if(R < 0 || C < 0 || R >= n || C >= n || grid[R][C] == 2) continue;

                    if(grid[R][C] == 1) return flip;

                    grid[R][C] = 2;
                    q.offer(new int[] {R, C});
                }
            }

            flip++;
        }

        return flip;
    }

    private void dfs(int r, int c, int[][] grid, Queue<int[]> q) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) return;

        grid[r][c] = 2;
        q.offer(new int[] {r, c});
        
        for(int i = 0; i < 4; i++) {
            int R = r + dr[i];
            int C = c + dc[i];

            dfs(R, C, grid, q);
        }
    }
}