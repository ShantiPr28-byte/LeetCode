class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];

        for(int num : nums1) {
            arr1[num]++;
        }
        for(int num : nums2) {
            arr2[num]++;
        }

        for(int i = 0; i < 1001; i++) {
            if(arr1[i] != 0 && arr2[i] != 0) {
                int minFreq = Math.min(arr1[i], arr2[i]);

                for(int f = 0; f < minFreq; f++) {
                    list.add(i);
                }
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}