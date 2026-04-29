class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for(int i = 0; i < n; i++) {
        //     nums1[m + i] = nums2[i];
        // }
        // Arrays.sort(nums1);

        int[] arr = new int[m + n];
        int i = 0, j = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                arr[i + j] = nums1[i];
                i++;
            } else {
                arr[i + j] = nums2[j];
                j++;
            }
        }
        
        while(i < m) {
            arr[i + j] = nums1[i]; 
            i++;
        }
        while(j < n) {
            arr[i + j] = nums2[j];
            j++;
        }

        for(int k = 0; k < m + n; k++) {
            nums1[k] = arr[k];
        }
    }
}