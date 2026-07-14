class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++) {
                int R = r + dr[i];
                int C = c + dc[i];

                if(R < 0 || C < 0 || R >= m || C >= n || mat[R][C] == 0) continue;

                if(mat[R][C] == -1) {
                    mat[R][C] = 1 + mat[r][c];
                    q.offer(new int[]{R, C});
                }
            }
        }

        return mat;
    }
}