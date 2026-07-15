class Solution {
    class Pair {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Pair>());
        }

        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adjList.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b. wt));
        pq.offer(new Pair(k, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int w = curr.wt;

            if(w > dist[u]) continue;
            for(Pair next : adjList.get(u)) {
                int v = next.node;
                int wt_v = next.wt;

                if(dist[v] > dist[u] + wt_v) {
                    dist[v] = dist[u] + wt_v;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}