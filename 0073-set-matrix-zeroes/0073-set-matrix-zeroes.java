class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for(int[] curr : list) {
            int row = curr[0];
            int col = curr[1];

            for(int j = 0; j < m; j++) {
                matrix[row][j] = 0;
            }

            for(int i = 0; i < n; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}