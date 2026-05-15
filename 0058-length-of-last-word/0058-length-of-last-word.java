class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int count = 0;

        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                int j = i;
                while(j >= 0 && s.charAt(j) != ' ') {
                    count++;
                    j--;
                }
                if(count > 0) break;
            }
        }

        return count;
    }
}