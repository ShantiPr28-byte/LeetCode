class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void solve(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        solve(index + 1, nums, subset, result);

        subset.remove(subset.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index+1]) {
            index++;
        }

        solve(index + 1, nums, subset, result);
    }
}