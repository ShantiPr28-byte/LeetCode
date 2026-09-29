class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {

            if(digits[i] % 2 != 0) continue;

            for(int j = 0; j < n; j++) {

                if(j == i) continue;

                for(int k = 0; k < n; k++) {

                    if(digits[k] == 0 || k == j || k == i) continue;

                    int num = digits[k] * 100 + digits[j] * 10 + digits[i];

                    set.add(num);
                }
            }
        }

        return set.size();
    }
}