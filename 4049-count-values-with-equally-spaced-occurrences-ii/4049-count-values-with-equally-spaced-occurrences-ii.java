class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int index = 0;
        for(int num : nums) {
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(index++);
        }

        int count = 0;

        for(List<Integer> indices : map.values()) {
            int size = indices.size();

            if(size >= 3) {
                int gap = indices.get(1) - indices.get(0);
                boolean equal = true;

                for(int i = 2; i < size; i++) {
                    if(indices.get(i) - indices.get(i - 1) != gap) {
                        equal = false;
                        break;
                    }
                }

                if(equal) count++;
            }
        }

        return count;
    }
}