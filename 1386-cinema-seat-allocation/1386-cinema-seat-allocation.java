class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];

            if(!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            map.get(row).add(col);
        }

        int ans = (n - map.size()) * 2;

        for(HashSet<Integer> seats : map.values()) {

            boolean left = !seats.contains(2) 
                        && !seats.contains(3)
                        && !seats.contains(4)
                        && !seats.contains(5);

            boolean middle = !seats.contains(4)
                        && !seats.contains(5)
                        && !seats.contains(6)
                        && !seats.contains(7);

            boolean right = !seats.contains(6)
                        && !seats.contains(7)
                        && !seats.contains(8)
                        && !seats.contains(9);

            if(left && right) {
                ans += 2;
            } else if(left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}