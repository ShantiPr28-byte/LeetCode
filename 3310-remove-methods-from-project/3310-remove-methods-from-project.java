class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];

            adjList.get(u).add(v);
        }

        boolean[] vis = new boolean[n];
        dfs(k, vis, adjList);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];

            if(!vis[u] && vis[v]) {
                for(int j = 0; j < n; j++) {
                    ans.add(j);
                }
                break;
            }
        }

        if(ans.size() == 0) {
            for(int i = 0; i < n; i++) {
                if(!vis[i]) {
                    ans.add(i);
                }
            }
        }

        return ans;
    }

    private void dfs(int k, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[k] = true;

        for(int nei : adjList.get(k)) {
            if(!vis[nei]) {
                dfs(nei, vis, adjList);
            }
        }
    }
}