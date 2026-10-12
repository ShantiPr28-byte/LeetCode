class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] freqDiff = new int[100001];

        long k = (long) k1 + k2;
        long totalDiff = 0;

        for(int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freqDiff[d]++;
            totalDiff += d;
        }

        if(totalDiff <= k) return 0;

        for(int i = 100000; i > 0 && k > 0; i--) {
            int reduce = (int) Math.min(freqDiff[i], k);

            freqDiff[i] -= reduce;
            freqDiff[i-1] += reduce;
            k -= reduce;
        }

        long ans = 0;

        for(int i = 1; i <= 100000; i++) {
            if(freqDiff[i] != 0) {
                ans += (long) i * i * freqDiff[i];
            }
        }

        return ans;
    }
}