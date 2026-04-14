class Solution {
    public int trap(int[] height) {
        int totalW = 0;
        int n = height.length;
        int start = 0;

        while (start < n - 1) {
            if (height[start] == 0) {
                start++;
                continue;
            }

            int end = start + 1;
            int maxEnd = end;
            int maxHeight = 0;
            while (end < n && height[end] < height[start]) {
                if (height[end] > maxHeight) {
                    maxHeight = height[end];
                    maxEnd = end;
                }
                end++;
            }
            if (end < n) {
                int h = Math.min(height[start], height[end]);
                for (int i = start + 1; i < end; i++) {
                    totalW += h - height[i];
                }
                start = end;
            } else {
                int h = Math.min(height[start], maxHeight);
                for (int i = start + 1; i <= maxEnd; i++) {
                    totalW += h - height[i];
                }
                start = maxEnd;
            }
        }

        return totalW;
    }
}
