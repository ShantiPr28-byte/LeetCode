class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(0, n - 1, nums);

        if(pivot == 0) {
            return binarySearch(0, n - 1, target, nums);
        }

        if(nums[0] > target) {
            return binarySearch(pivot, n - 1, target, nums);
        }

        return binarySearch(0, pivot - 1, target, nums);
    }

    private int findPivot(int left, int right, int[] nums) {
        if(nums[left] < nums[right]) return left;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearch(int left, int right, int target, int[] nums) {
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            else if(nums[mid] > target) {
                right = mid - 1;
            } 

            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}