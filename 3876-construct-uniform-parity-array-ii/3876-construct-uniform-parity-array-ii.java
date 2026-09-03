class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        int minOdd = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(nums1[i] % 2 != 0) {
                minOdd = Math.min(nums1[i], minOdd);
            }
        }

        for(int i = 0; i < n; i++) {
            if(minOdd != Integer.MAX_VALUE) {
                if(nums1[i] % 2 == 0) {
                    if(nums1[i] <= minOdd) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}