class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[n+1];

        for(int i = 0; i < relations.length; i++) {
            int u = relations[i][0];
            int v = relations[i][1];

            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] finishTime = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            finishTime[i] = time[i-1];
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int neighbor : adjList.get(node)) {
                finishTime[neighbor] = Math.max(finishTime[neighbor], finishTime[node] + time[neighbor - 1]);
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, finishTime[i]);
        }

        return ans;
    }
}