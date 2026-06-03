import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        // Land -> Water
        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        // Water -> Land
        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];

        long[] prefixMinDur = new long[m];
        long[] suffixMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] =
                Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMinStartPlusDur[m - 1] =
            (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinStartPlusDur[i] = Math.min(
                suffixMinStartPlusDur[i + 1],
                (long) rides[i][0] + rides[i][1]
            );
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long endTime = (long) firstStart[i] + firstDur[i];

            int idx = upperBound(starts, (int) endTime) - 1;

            if (idx >= 0) {
                ans = Math.min(ans,
                        endTime + prefixMinDur[idx]);
            }

            if (idx + 1 < m) {
                ans = Math.min(ans,
                        suffixMinStartPlusDur[idx + 1]);
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}