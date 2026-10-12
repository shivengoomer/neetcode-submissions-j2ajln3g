
class Solution {
    public int hammingWeight(int n) {
        int curr = n;
        int ct = 0;
        while (curr != 0) {
            ct = (curr & 1) == 1 ? ct + 1 : ct;
            curr = curr >>> 1;
        }

        return ct;
    }
}
