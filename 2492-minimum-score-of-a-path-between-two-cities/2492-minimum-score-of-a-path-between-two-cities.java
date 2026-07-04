class Solution {
    public int minScore(int n, int[][] roads) {
        // int min = (int)1e9;
        // for(int[] curr : roads) {
        //     min = Math.min(min, curr[2]);
        // }

        // return min;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] curr : roads) {
            int u = curr[0];
            int v = curr[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, vis, adjList);

        int min = (int) 1e9;
        for(int[] curr : roads) {
            int node = curr[0];
            if(vis[node]) {
                min = Math.min(min, curr[2]);
            }
        }

        return min;
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[node] = true;

        for(int neiNode : adjList.get(node)) {
            if(!vis[neiNode]) {
                dfs(neiNode, vis, adjList);
            }
        }
    }
}