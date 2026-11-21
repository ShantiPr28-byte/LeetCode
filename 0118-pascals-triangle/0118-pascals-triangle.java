class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
            ans.get(i).add(1);

            for(int j = 1; j < i; j++) {
                int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                ans.get(i).add(val);
            }

            if(i != 0) ans.get(i).add(1);
        }

        return ans;
    }
}