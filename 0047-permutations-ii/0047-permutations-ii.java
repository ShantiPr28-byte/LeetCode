class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        findPermutation(0, nums, result);

        return result;
    }

    private void findPermutation(int idx, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            List<Integer> curr = new ArrayList<>();

            for(int num : nums) {
                curr.add(num);
            }

            result.add(curr);
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = idx; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);

            swap(idx, i, nums);

            findPermutation(idx + 1, nums, result);

            swap(idx, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}