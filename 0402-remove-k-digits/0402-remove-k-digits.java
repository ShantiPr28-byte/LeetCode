class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        
        Stack<Integer> st = new Stack<>();

        for (char ch : num.toCharArray()) {
            int val = ch - '0';

            while (k > 0 && !st.isEmpty() && st.peek() > val) {
                st.pop();
                k--;
            }

            st.push(val);
        }

        while(k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(int digit : st) {
            sb.append(digit);
        }

        //Remove leading zeros
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String ans = sb.substring(i);

        return ans == "" ? "0" : ans;
    }
}