class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        boolean canPlant = true;

        for(int i = 0; i < flowerbed.length; i++) {
            if(n == 0) return true;

            if(flowerbed[i] == 1) {
                canPlant = false;
            } else {
                if(canPlant && n > 0) {
                    if(i < m - 1 && flowerbed[i+1] != 1) {
                        n--;
                        canPlant = false;
                        continue;
                    }
                    if(i == m - 1) n--;
                }

                canPlant = true;
            }
        }

        return n == 0;
    }
}