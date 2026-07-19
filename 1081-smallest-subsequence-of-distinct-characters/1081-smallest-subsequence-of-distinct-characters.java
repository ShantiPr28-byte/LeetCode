class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character, Integer> last = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }

        HashSet<Character> visited = new HashSet<>();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(visited.contains(ch)) continue;

            while(!st.isEmpty() && st.peek() > ch && last.get(st.peek()) > i) {
                visited.remove(st.pop());
            }
            
            st.push(ch);
            visited.add(ch);
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}