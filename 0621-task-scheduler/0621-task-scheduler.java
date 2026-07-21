class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }

        int maxFreq = Integer.MIN_VALUE;
        for(int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        int countMax = 0;
        for(int f : freq) {
            if(f == maxFreq) {
                countMax++;
            }
        }

        int length = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(tasks.length, length);
    }
}