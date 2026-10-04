class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        helper(0, digits, map, new StringBuilder(), ans);

        return ans;
    }

    private void helper(int idx, String digits, String[] map, StringBuilder sb, List<String> ans) {
        if(idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String mapping = map[digit];

        for(int i = 0; i < mapping.length(); i++) {
            sb.append(mapping.charAt(i));
            helper(idx + 1, digits, map, sb, ans);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}