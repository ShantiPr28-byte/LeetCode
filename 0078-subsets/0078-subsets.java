class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());

        for(int num : nums) {
            int size = powerSet.size();

            for(int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(powerSet.get(i));
                subset.add(num);
                powerSet.add(subset);
            }
        }

        return powerSet;
    }
}