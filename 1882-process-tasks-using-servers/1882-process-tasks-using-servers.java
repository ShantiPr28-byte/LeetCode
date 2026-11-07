class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                } else if(a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                } else {
                    return Long.compare(a[2], b[2]);
                }
            }
        );

        for(int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        long time = 0;

        for(int j = 0; j < m; j++) {

            //current time cannot be earlier than the task arrival
            time = Math.max(time, j);

            //Release all servers that have finished
            while(!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                long weight = server[1];
                long index = server[2];

                available.offer(new int[]{
                    (int) weight,
                    (int) index
                });
            }

            //If no sever is free, wait
            if(available.isEmpty()) {
                time = busy.peek()[0];

                //Release all servers finishing at this time
                while(!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    available.offer(new int[] {
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            //select the best available server
            int[] server = available.poll();
            int weight = server[0];
            int index = server[1];

            ans[j] = index;

            long finishTime = time + tasks[j];

            busy.offer(new long[] {finishTime, weight, index});
        }

        return ans;
    }
}