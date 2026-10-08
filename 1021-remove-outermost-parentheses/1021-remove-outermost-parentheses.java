class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int open = 0;
        int close = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                open++;
                sb.append('(');
            } else {
                close++;
                sb.append(')');
            }

            if(open == close) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(i);

                i = sb.length();
            }
        }

        return sb.toString();
    }
}