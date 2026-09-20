class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] taken = new boolean[nums.length];

        helper(new ArrayList<>(), taken, nums, result);

        return result;
    }

    private void helper(List<Integer> curr, boolean[] taken, int[] nums, List<List<Integer>> result) {
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!taken[i]) {
                curr.add(nums[i]);
                taken[i] = true;

                helper(curr, taken, nums, result);

                curr.remove(curr.size() - 1);
                taken[i] = false;
            }
        }
    }
}