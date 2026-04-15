class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidates, target, current, ans);

        return ans;
    }

    private void solve(int i, int[] arr, int target, List<Integer> current, List<List<Integer>> ans) {
        // Base case
        if(target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if(i == arr.length || target < 0) {
            return;
        }

        // Take
        current.add(arr[i]);
        solve(i, arr, target - arr[i], current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Skip
        solve(i + 1, arr, target, current, ans);
    }
}