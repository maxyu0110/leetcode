public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int res = 10 + 81;
        int curChoose = 8;
        int last = 81;
        n -= 2;
        while(n-- > 0){
            last *= curChoose--;
            res += last;
            if(last == 0) break;
        }
        return res;
    }
    /*
    f(k) = 9*9*8*...*(9- k + 2);
f(k)长度为k的数字，不同的具有unique数字的个数. 因为第一个数字有9种选择（第一个数字不能为0），第二个数字有9种选择，第三个数字有8种选择以此类推。
所以我们要把长度从1到n的unique数字加起来。
k > 2
f(k) = f(k-1) * (9 - k + 2);
    */
}