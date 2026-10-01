class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {

            if(matrix[i][0] > target) return false;

            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == target) {
                    return true;
                } else if(matrix[i][j] > target) {
                    break;
                }
            }
        }

        return false;
    }
}