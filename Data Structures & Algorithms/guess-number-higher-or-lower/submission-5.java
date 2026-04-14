public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int res = guess(mid);
            if (res == -1) {
                end = mid - 1;
            } else if (res == 1) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; 
    }
}
