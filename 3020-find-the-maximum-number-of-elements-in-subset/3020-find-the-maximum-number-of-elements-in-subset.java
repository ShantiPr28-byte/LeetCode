class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put((long) num, map.getOrDefault((long)num, 0) + 1);
        }

        int ans = 1;
        if(map.containsKey(1L)) {
            int count = map.get(1L);
            ans = Math.max(ans, (count % 2 == 0) ? count - 1 : count);
        }

        for(long x : map.keySet()) {
            if(x == 1L) continue;

            long curr = x;
            int len = 0;

            boolean broke = false;
            while(map.getOrDefault(curr, 0) >= 2) {
                len = len + 2;

                if (curr > 1000000000L / curr) {
                    broke = true;
                    break;
                }
                curr *= curr;
            }

            if(broke) {
                len--;
            } else if(map.getOrDefault(curr, 0) >= 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}