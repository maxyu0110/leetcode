/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int mid = 1 + (n - 1)/2;
        int start = 1;
        int end = n;
        int res = guess(mid);
        while(res != 0 && start <= end) {
            if(res == 1) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
            mid = start + (end - start)/2;
            res = guess(mid);
        }
        return mid;
    }
}