class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if(ch == ')' && st.peek() == '(') {
                st.pop();
            }  else if(ch == '}' && st.peek() == '{') {
                st.pop();
            }  else if(ch == ']' && st.peek() == '[') {
                st.pop();
            }
        }

        if(st.isEmpty()) return true;
        return false;
    }
}