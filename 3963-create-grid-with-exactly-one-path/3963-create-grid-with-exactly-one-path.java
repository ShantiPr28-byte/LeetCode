class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        char[][] grid = new char[m][n];
        for(int i = 0; i < m; i++) {
            grid[i][0] = '.';
        }
        for(int j = 0; j < n; j++) {
            grid[m-1][j] = '.';
        }

        for(int i = 0; i < m; i++) {
            String s = "";
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != '.') {
                    grid[i][j] = '#';
                }
                s += grid[i][j];
            }
            ans[i] = s;
        }

        return ans;
    }
}