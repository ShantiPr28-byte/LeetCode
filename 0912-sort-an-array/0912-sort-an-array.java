class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergeSort(0, n - 1, nums);

        return nums;
    }

    private void mergeSort(int l, int r, int[] nums) {
        if(l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(l, mid, nums);
        mergeSort(mid + 1, r, nums);

        merge(l, mid, r, nums);
    }

    private void merge(int l, int mid, int r, int[] nums) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i = 0; i < n1; i++) {
            leftArray[i] = nums[l + i];
        }

        for(int i = 0; i < n2; i++) {
            rightArray[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while(i < n1) {
            nums[k++] = leftArray[i++];
        }

        while(i < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}