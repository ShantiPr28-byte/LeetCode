class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] taken = new boolean[nums.length];

        helper(0, new ArrayList<>(), taken, nums, result);

        return result;
    }

    private void helper(int idx, List<Integer> curr, boolean[] taken, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!taken[i]) {
                curr.add(nums[i]);
                taken[i] = true;

                helper(idx + 1, curr, taken, nums, result);

                curr.remove(curr.size() - 1);
                taken[i] = false;
            }
        }
    }
}