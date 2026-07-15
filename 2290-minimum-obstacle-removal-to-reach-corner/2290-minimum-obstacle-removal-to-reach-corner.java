class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();

        dist[0][0] = 0;
        dq.offerFirst(new int[] {0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++) {
                int R = r + dr[i];
                int C = c + dc[i];

                if(R < 0 || C < 0 || R >= m || C >= n) continue;

                int cost = grid[R][C];
                if(dist[r][c] + cost < dist[R][C]) {
                    dist[R][C] = dist[r][c] + cost;

                    if(cost == 0) dq.offerFirst(new int[] {R, C});
                    else dq.offerLast(new int[] {R, C});
                } 
            }
        }

        return dist[m-1][n-1];
    }
}