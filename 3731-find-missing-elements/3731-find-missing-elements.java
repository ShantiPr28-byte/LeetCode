class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int smallest = 101;
        int largest = 0;

        for(int num : nums) {
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
            set.add(num);
        }

        for(int i = smallest; i <= largest; i++) {
            if(!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}