class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        helper(0, new ArrayList<>(), nums, set);

        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> list : set) {
            result.add(list);
        }

        return result;
    }

    private void helper(int idx, List<Integer> curr, int[] nums, Set<List<Integer>> set) {
        if(idx == nums.length) {
            List<Integer> temp = new ArrayList<>(curr);
            Collections.sort(temp);
            set.add(temp);
            return;
        }

        curr.add(nums[idx]);
        helper(idx + 1, curr, nums, set);

        curr.remove(curr.size() - 1);
        helper(idx + 1, curr, nums, set);
    }
}