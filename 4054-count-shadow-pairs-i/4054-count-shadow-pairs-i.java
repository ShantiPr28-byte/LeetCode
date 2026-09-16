class Solution {
    public long shadowPairs(int[] nums) {
        Stack<Integer> st = new Stack<>();

        long ans = 0;

        for(int x : nums) {
            while(!st.isEmpty() && st.peek() > x) {
                st.pop();
            }

            int left = 0;
            int right = st.size();

            while(left < right) {
                int mid = left + (right - left) / 2;

                if(st.get(mid) < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            ans += left;
            st.push(x);
        }

        return ans;
    }
}