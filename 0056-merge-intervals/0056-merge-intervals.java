class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        result.add(curr);

        for(int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if(curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                curr = next;
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}