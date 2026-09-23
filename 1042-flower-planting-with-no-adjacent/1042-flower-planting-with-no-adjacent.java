class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] flower = new int[n];

        solve(1, n, flower, paths);

        return flower;
    }

    private boolean solve(int node, int n, int[] flower, int[][] paths) {
        if(node > n) return true;

        for(int i = 1; i <= 4; i++) {
            if(isSafe(node, i, flower, paths)) {
                flower[node - 1] = i;

                if(solve(node + 1, n, flower, paths)) return true;
                else {
                    flower[node - 1] = 0;
                }
            }
        }

        return false;
    }

    private boolean isSafe(int node, int i, int[] flower, int[][] paths) {
        for(int[] path : paths) {
            if(path[0] == node) {
                if(flower[path[1] - 1] == i) return false;
            } else if(path[1] == node) {
                if(flower[path[0] - 1] == i) return false;
            }
        }

        return true;
    }
}