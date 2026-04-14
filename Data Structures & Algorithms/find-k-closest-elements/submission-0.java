class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[] temp = new int[n];

        // Step 1: store absolute differences
        for (int i = 0; i < n; i++) {
            temp[i] = Math.abs(arr[i] - x);
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[n]; 
        for (int count = 0; count < k; count++) {
            int minDiff = Integer.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    if (temp[i] < minDiff ||
                       (temp[i] == minDiff && arr[i] < arr[idx])) {
                        minDiff = temp[i];
                        idx = i;
                    }
                }
            }

            used[idx] = true;
            ans.add(arr[idx]);
        }
        Collections.sort(ans);
        return ans;
    }
}