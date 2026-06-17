class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int src = image[sr][sc];

        if(src == color) return image;

        dfs(sr, sc, src, color, image);

        return image;
    }

    private void dfs(int r, int c, int src, int color, int[][] image) {
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != src) {
            return;
        }

        image[r][c] = color;

        for(int i = 0; i < 4; i++) {
            int R = r + dr[i];
            int C = c + dc[i];

            dfs(R, C, src, color, image);
        }
    }
}