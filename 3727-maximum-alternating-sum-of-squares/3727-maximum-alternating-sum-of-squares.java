class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for(int num : nums) {
            arr[i++] = Math.abs(num);
        }

        Arrays.sort(arr);

        long ans = 0;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            ans += arr[right] * arr[right];
            ans -= arr[left] * arr[left];

            right--;
            left++;
        }

        if(left == right) ans += arr[left] * arr[left];
        return ans;
    }
}