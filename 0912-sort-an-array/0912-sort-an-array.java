class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if(low == high) return;

        int mid = low + (high - low) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low, right = mid + 1;
        int i = 0;

        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                temp[i] = nums[left];
                left++;
            } else {
                temp[i] = nums[right];
                right++;
            }
            i++;
        }

        while(left <= mid) {
            temp[i++] = nums[left++];
        }

        while(right <= high) {
            temp[i++] = nums[right++];
        }

        for(i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}