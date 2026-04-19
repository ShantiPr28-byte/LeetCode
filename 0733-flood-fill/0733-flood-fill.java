class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int src = image[sr][sc];

        // Important optimization
        if(src == color) return image;

        dfs(sr, sc, src, image, color);

        return image;
    }

    private void dfs(int r, int c, int src, int[][] image, int color) {
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != src) {
            return;
        }

        image[r][c] = color;

        for(int k = 0; k < 4; k++) {
            int R = r + dr[k];
            int C = c + dc[k];

            dfs(R, C, src, image, color);
        }
    }
}