class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(new ArrayList<>(), 0, nums, result);

        return result;
    }

    private void helper(List<Integer> curr, int idx, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(curr, idx + 1, nums, result);

        curr.remove(curr.size() - 1);

        helper(curr, idx + 1, nums, result);
    }
}