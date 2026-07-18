class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
            indegree[v]++;
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ancestors.add(new TreeSet<>());
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int neighbor : adjList.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));

                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(ancestors.get(i)));
        }

        return ans;
    }
}