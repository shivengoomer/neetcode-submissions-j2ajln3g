class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long hoursSpent = 0;
            for (int pile : piles) {
                hoursSpent += (pile + mid - 1) / mid;
            }
            if (hoursSpent <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}