class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>());

        for(int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();

            for(List<Integer> subset : set) {
                List<Integer> curr = new ArrayList<>(subset);
                curr.add(num);
                newSubsets.add(curr);
            }

            set.addAll(newSubsets);
        }

        return new ArrayList<>(set);
    }
}