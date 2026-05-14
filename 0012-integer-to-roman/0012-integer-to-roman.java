class Solution {
    public String intToRoman(int num) {
        int[] base = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        return solve(num, base.length - 1, base, symbol);
    }

    private String solve(int num, int idx, int[] base, String[] symbol) {
        if(idx < 0) {
            return "";
        }

        if(num >= base[idx]) {
            return symbol[idx] + solve(num - base[idx], idx, base, symbol);
        } else {
            return solve(num, idx - 1, base, symbol);
        }
    }
}