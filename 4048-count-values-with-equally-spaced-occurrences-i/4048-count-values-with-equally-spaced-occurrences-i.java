class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int i = 0;
        for(int num : nums) {
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i++);
        }

        int count = 0;

        for(List<Integer> indices : map.values()) {
            if(indices.size() == 3) {
                int i1 = indices.get(0);
                int i2 = indices.get(1);
                int i3 = indices.get(2);

                if(i2 - i1 == i3 - i2) count++;
            }
        }

        return count;
    }
}