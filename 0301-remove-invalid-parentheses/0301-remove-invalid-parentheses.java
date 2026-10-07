class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                leftRemove++;    
            }
            else if(ch == ')') {
                if(leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        Set<String> set = new HashSet<>();

        backtrack(0, leftRemove, rightRemove, 0, new StringBuilder(), s, set);

        return new ArrayList<>(set);
    }

    private void backtrack(int idx, int leftRemove, int rightRemove, int balance, StringBuilder sb, String s, Set<String> set) {
        if(idx == s.length()) {
            if(leftRemove == 0 && rightRemove == 0 && balance == 0) {
                set.add(sb.toString());
            }
            return;
        }

        //case1: character is '('
        if(s.charAt(idx) == '(') {

            //remove
            if(leftRemove > 0) {
                backtrack(idx + 1, leftRemove - 1, rightRemove, balance, sb, s, set);
            }

            //keep
            sb.append('(');
            backtrack(idx + 1, leftRemove, rightRemove, balance + 1, sb, s, set);

            sb.deleteCharAt(sb.length() - 1);
        } 

        //case1: character is ')'
        else if(s.charAt(idx) == ')') {

            //remove
            if(rightRemove > 0) {
                backtrack(idx + 1, leftRemove, rightRemove - 1, balance, sb, s, set);
            }

            //keep
            if(balance > 0) {
                sb.append(')');
                backtrack(idx + 1, leftRemove, rightRemove, balance - 1, sb, s, set);

                sb.deleteCharAt(sb.length() - 1);
            }
        } 

        //case1: character is letter
        else {
            sb.append(s.charAt(idx));
            backtrack(idx + 1, leftRemove, rightRemove, balance, sb, s, set);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}