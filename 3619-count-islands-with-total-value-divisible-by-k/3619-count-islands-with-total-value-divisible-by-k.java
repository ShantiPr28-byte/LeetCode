class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    long sum = dfs(i, j, grid);

                    if(sum % k == 0) ans++;
                }
            }
        }

        return ans;
    }

    private long dfs(int r, int c, int[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        long sum = grid[r][c];
        grid[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            int R = r + dr[i];
            int C = c + dc[i];

            sum += dfs(R, C, grid);
        }

        return sum;
    }
}