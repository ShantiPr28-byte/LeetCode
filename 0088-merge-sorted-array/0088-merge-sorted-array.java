class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1st Appraoch
        // for(int i = 0; i < n; i++) {
        //     nums1[m + i] = nums2[i];
        // }
        // Arrays.sort(nums1);

        //2nd Appraoch
        // int[] arr = new int[m + n];
        // int i = 0, j = 0;

        // while(i < m && j < n) {
        //     if(nums1[i] <= nums2[j]) {
        //         arr[i + j] = nums1[i];
        //         i++;
        //     } else {
        //         arr[i + j] = nums2[j];
        //         j++;
        //     }
        // }
        
        // while(i < m) {
        //     arr[i + j] = nums1[i]; 
        //     i++;
        // }
        // while(j < n) {
        //     arr[i + j] = nums2[j];
        //     j++;
        // }

        // for(int k = 0; k < m + n; k++) {
        //     nums1[k] = arr[k];
        // }

        //3rd Appraoch
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}