class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        
        helper(0, new ArrayList<>(), target, candidates, result);

        return result;
    }

    private void helper(int idx, List<Integer> curr, int target, int[] candidates, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if(idx == candidates.length || candidates[idx] > target) return;

        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] > target) break;
        
            curr.add(candidates[i]);

            helper(i + 1, curr, target - candidates[i], candidates, result);

            curr.remove(curr.size() - 1);
        } 
    }
}