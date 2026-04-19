class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        bfs(adj, indegree, ans);
        if(ans.size() == numCourses) return true;
        return false;
    }

    private void bfs(ArrayList<ArrayList<Integer>> adj, int[] indegree, ArrayList<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            ArrayList<Integer> temp = adj.get(node);
            for(int i = 0; i < temp.size(); i++) {
                indegree[temp.get(i)]--;
                if(indegree[temp.get(i)] == 0) {
                    q.offer(temp.get(i));
                }
            } 
        }
    }
}