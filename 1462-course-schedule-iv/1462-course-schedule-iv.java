class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Set<Integer>> ancestors = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            ancestors.add(new TreeSet<>());
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

        List<Boolean> ans = new ArrayList<>();

        for(int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if(ancestors.get(v).contains(u)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}