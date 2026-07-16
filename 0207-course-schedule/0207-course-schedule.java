class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adjList.get(u).add(v);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] parVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i]) {
                if(dfs(i, vis, parVis, adjList)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, boolean[] vis, boolean[] parVis, ArrayList<ArrayList<Integer>> adjList) {
        vis[node] = true;
        parVis[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(!vis[neighbor]) {
                if(dfs(neighbor, vis, parVis, adjList)) {
                    return true;
                }
            } else if (parVis[neighbor]) {
                return true;
            }
        }

        parVis[node] = false;

        return false;
    }
}