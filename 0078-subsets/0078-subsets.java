class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(0, new ArrayList<>(), nums, result);

        return result;
    }

    private void helper(int idx, List<Integer> curr, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(idx + 1, curr, nums, result);

        curr.remove(curr.size() - 1);
        helper(idx + 1, curr, nums, result);
    }
}