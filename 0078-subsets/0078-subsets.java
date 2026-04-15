class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, nums, current, ans);
        return ans;
    }

    private void solve(int i, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        //Include
        current.add(nums[i]);
        solve(i+1, nums, current, ans);

        //Backtrack
        current.remove(current.size() - 1);

        //Exclude
        solve(i+1, nums, current, ans);
    }
}