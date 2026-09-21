class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        boolean[][] rowCheck = new boolean[n+1][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rowCheck[i+1][matrix[i][j]] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(!rowCheck[i][j]) return false;
            }
        }

        boolean[][] colCheck = new boolean[n+1][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                colCheck[i+1][matrix[j][i]] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(!colCheck[i][j]) return false;
            }
        }

        return true;
    }
}