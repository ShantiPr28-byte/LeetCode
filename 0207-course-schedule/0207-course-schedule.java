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

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int neighbor : adjList.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        if(q.size() == 0) return false;

        int course = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            course++;

            for(int neighbor : adjList.get(node)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return course == numCourses;
    }
}