class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        solve(0, s, path, result);

        return result;
    }

    private void solve(int idx, String s, List<String> path, List<List<String>> result) {
        if(idx == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(idx, i, s)) {
                path.add(s.substring(idx, i + 1));

                solve(i + 1, s, path, result);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }    
}