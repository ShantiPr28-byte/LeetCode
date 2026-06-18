class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adjList.get(u).add(new int[] {v, cost});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(stops > k) continue;

            for(int[] nei : adjList.get(node)) {
                int nextNode = nei[0];
                int nextCost = nei[1];

                if(cost + nextCost < dist[nextNode]) {
                    dist[nextNode] = cost + nextCost;
                    q.offer(new int[] {nextNode, dist[nextNode], stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}