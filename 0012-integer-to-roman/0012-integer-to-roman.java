class Solution {
    public String intToRoman(int num) {
        int[] base = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        int i = base.length - 1;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int div = num / base[i];
            while(div > 0) {
                sb.append(symbol[i]);
                div--;
            }

            num = num % base[i];
            i--;
        }

        return sb.toString();
    }
}