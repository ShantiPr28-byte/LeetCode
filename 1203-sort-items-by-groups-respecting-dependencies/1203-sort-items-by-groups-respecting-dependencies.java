class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // item graph
        ArrayList<ArrayList<Integer>> adjItem = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjItem.add(new ArrayList<>());
        }

        int[] indegreeItem = new int[n];

        for(int i = 0; i < n; i++) {
            if(beforeItems.get(i).size() == 0) continue;

            for(int item : beforeItems.get(i)) {
                adjItem.get(item).add(i);
                indegreeItem[i]++;
            }
        }

        // group graph
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        ArrayList<HashSet<Integer>> adjGroup = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            adjGroup.add(new HashSet<>());
        }

        int[] indegreeGroup = new int[m];

        for(int v = 0; v < n; v++) {
            for(int u : beforeItems.get(v)) {
                int gu = group[u];
                int gv = group[v];

                if(gu != gv) {
                    if(adjGroup.get(gu).add(gv)) {
                        indegreeGroup[gv]++;
                    }
                }
            }
        }

        // topological sort on group
        List<Integer> groupOrder = topoSort(adjGroup, indegreeGroup);
        if(groupOrder.size() != m) {
            return new int[]{};
        }

        // topological sort on item
        List<Integer> itemOrder = topoSort(adjItem, indegreeItem);
        if (itemOrder.size() != n) {
            return new int[0];
        }

        // put items into their groups in topological order
        HashMap<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemOrder) {
            groupToItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        // build the final answer
        int[] ans = new int[n];
        int idx = 0;

        for (int g : groupOrder) {
            List<Integer> items = groupToItems.get(g);

            if (items == null) {
                continue;
            }

            for (int item : items) {
                ans[idx++] = item;
            }
        }

        return ans;
    }

    private List<Integer> topoSort(ArrayList<? extends Iterable<Integer>> adj, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return order;
    }
}