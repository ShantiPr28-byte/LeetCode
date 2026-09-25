class Solution {
    public String getPermutation(int n, int k) {
        List<String> allPermutations = new ArrayList<>();

        boolean[] used = new boolean[n + 1];

        helper(n, new StringBuilder(), used, allPermutations);

        return allPermutations.get(k - 1);
    }

    private void helper(int n, StringBuilder sb, boolean[] used, List<String> list) {
        if(sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for(int i = 1; i <= n; i++) {

            if(used[i] == true) continue;

            used[i] = true;
            sb.append(i);

            helper(n, sb, used, list);

            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}