class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                StringBuilder curr = new StringBuilder();
                while(i >= 0 && s.charAt(i) != ' ') {
                    curr.append(s.charAt(i));
                    i--;
                }
                sb.append(curr.reverse());
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    } 
}