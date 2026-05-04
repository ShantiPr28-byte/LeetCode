class Solution {
    public int hIndex(int[] citations) {
        for(int i = 1; i <= citations.length; i++) {
            int count = 0;
            for(int j = 0; j < citations.length; j++) {
                if(citations[j] >= i) count++;
                if(count == i) continue;
            }

            if(count < i) return i - 1;
        }

        return citations.length;
    }
}