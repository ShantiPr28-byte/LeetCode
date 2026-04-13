class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int len = n - k + 1;
        int[] result = new int[len];

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            // Remove out of window element
            if(!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Remove smaller element from back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current element index
            dq.add(i);

            // Store result
            if(i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}