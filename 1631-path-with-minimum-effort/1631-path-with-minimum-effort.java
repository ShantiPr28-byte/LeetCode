class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        dist[0][0] = 0;
        pq.offer(new int[] {0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int effort = curr[2];

            if(effort > dist[r][c]) continue;

            if(r == m - 1 && c == n - 1) return effort;

            for(int i = 0; i < 4; i++) {
                int R = r + dr[i];
                int C = c + dc[i];

                if(R < 0 || C < 0 || R >= m || C >= n) continue;

                int edgeDiff = Math.abs(heights[r][c] - heights[R][C]);
                int newEffort = Math.max(effort, edgeDiff);

                if(newEffort < dist[R][C]) {
                    dist[R][C] = newEffort;
                    pq.offer(new int[] {R, C, newEffort});
                }
            }
        }

        return 0;
    }
}