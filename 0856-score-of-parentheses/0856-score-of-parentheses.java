class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push(0);
            } else {
                int value = st.pop();
                int score;

                if(value == 0) {
                    score = 1;
                } else {
                    score = value * 2;
                }

                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }
}