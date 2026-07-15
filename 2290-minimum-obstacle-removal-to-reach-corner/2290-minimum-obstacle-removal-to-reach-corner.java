class Solution {
    class Pair {
        int r;
        int c;
        int h;

        public Pair(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.h, b.h));

        pq.offer(new Pair(0, 0, 0));
        vis[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int h = curr.h;

            for(int i = 0; i < 4; i++) {
                int R = r + dr[i];
                int C = c + dc[i];

                if(R == m - 1 && C == n - 1) return h;

                if(R < 0 || C < 0 || R >= m || C >= n || vis[R][C]) continue;

                vis[R][C] = true;
                if(grid[R][C] == 1) {
                    pq.offer(new Pair(R, C, h + 1));
                } else {
                    pq.offer(new Pair(R, C, h));
                }

            }
        }

        return -1;
    }
}