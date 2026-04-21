class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] result = new int[n][m];
        int[][] time = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        for(int[] s : sources) {
            int r = s[0];
            int c = s[1];
            int color = s[2];

            q.offer(new int[]{r, c});
            result[r][c] = color;
            time[r][c] = 0;
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            int t = time[r][c];
            int color = result[r][c];

            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int newTime = t + 1;
                if(newTime < time[nr][nc]) {
                    time[nr][nc] = newTime;

                    result[nr][nc] = color;

                    q.offer(new int[]{nr, nc});
                } else if(newTime == time[nr][nc]) {
                    result[nr][nc] = Math.max(result[nr][nc], color);
                }
            }
        }

        return result;
    }
}







