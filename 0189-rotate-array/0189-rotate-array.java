class Solution {
    public void rotate(int[] nums, int k) {
        // Juggling algorithm
        int n = nums.length;
        k = k % n;
        int cycles = gcd(n, k);

        for(int i = 0; i < cycles; i++) {
            int currIdx = i;
            int prevValue = nums[i];

            while(true) {
                int nextIdx = (currIdx + k) % n;
                int temp = nums[nextIdx];
                nums[nextIdx] = prevValue;

                prevValue = temp;
                currIdx = nextIdx;

                if (currIdx == i) break;
            }
        }
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}