class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int src = image[sr][sc];

        if(src == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int k = 0; k < 4; k++) {
                int R = r + dr[k];
                int C = c + dc[k];

                if(R < 0 || C < 0 || R >= m || C >= n) continue;

                if(image[R][C] == src) {
                    image[R][C] = color;
                    q.offer(new int[]{R, C});
                }
            }
        }

        return image;
    }
}