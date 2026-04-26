class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        solve(0, new ArrayList<>(), powerSet, nums);

        return powerSet;
    }

    private void solve(int index, List<Integer> subset, List<List<Integer>> powerSet, int[] nums) {
        if(index == nums.length) {
            powerSet.add(new ArrayList<>(subset));
            return;
        } 

        //Add element
        subset.add(nums[index]);
        solve(index + 1, subset, powerSet, nums);

        //Backtrack
        subset.remove(subset.size() - 1);

        //Skip element
        solve(index + 1, subset, powerSet, nums);
    }
}