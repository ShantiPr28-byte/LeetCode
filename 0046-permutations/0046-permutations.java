class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(0, nums, result);

        return result;
    }

    private void helper(int idx, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) {
                temp.add(num);
            }

            result.add(temp);
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);

            helper(idx + 1, nums, result);

            swap(i, idx, nums);
        }
    }

    private void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}