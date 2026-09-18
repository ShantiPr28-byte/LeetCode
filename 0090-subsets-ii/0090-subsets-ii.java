class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        helper(0, new ArrayList<>(), nums, result);

        return result;
    }

    private void helper(int idx, List<Integer> curr, int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            helper(i + 1, curr, nums, result);

            curr.remove(curr.size() - 1);
        }
    }
}