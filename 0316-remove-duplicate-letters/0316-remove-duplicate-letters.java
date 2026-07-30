class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        Stack<Character> st = new Stack<>();

        int i = 0;
        for(char ch : s.toCharArray()) {
            if(st.contains(ch)) {
                i++;
                continue;
            }

            if(st.isEmpty()) {
                st.push(ch);
            } else {
                while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i) {
                    st.pop();
                }
                st.push(ch);
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}