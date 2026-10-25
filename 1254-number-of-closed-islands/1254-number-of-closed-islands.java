class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int island = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    if(dfs(i, j, visited, grid)) {
                        island++;
                    }
                }
            }
        }

        return island;
    }

    private boolean dfs(int r, int c, boolean[][] visited, int[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return false;
        }

        if(grid[r][c] == 1 || visited[r][c]) {
            return true;
        }

        visited[r][c] = true;

        boolean closed = true;

        for(int i = 0; i < 4; i++) {
            int R = r + dr[i];
            int C = c + dc[i];

            if(!dfs(R, C, visited, grid)) {
                closed = false;
            }
        }

        return closed;
    }
}