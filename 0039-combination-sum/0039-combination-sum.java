class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        solve(0, target, new ArrayList<>(), result, candidates);

        return result;
    }

    private void solve(int idx, int target, List<Integer> curr, List<List<Integer>> result, int[] candidates) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return;

        if(idx >= candidates.length) return;

        if(candidates[idx] <= target) {
            curr.add(candidates[idx]);
            solve(idx, target - candidates[idx], curr, result, candidates);

            curr.remove(curr.size() - 1);
        }

        solve(idx + 1, target, curr, result, candidates);
    }
}