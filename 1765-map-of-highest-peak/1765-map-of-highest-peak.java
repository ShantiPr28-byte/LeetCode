class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    q.offer(new int[] {i, j});
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++) {
                int R = r + dr[i];
                int C = c + dc[i];

                if(R < 0 || C < 0 || R >= m || C >= n || isWater[R][C] != -1) continue;
                isWater[R][C] = isWater[r][c] + 1;
                q.offer(new int[] {R, C});
            }
        }

        return isWater;
    }
}