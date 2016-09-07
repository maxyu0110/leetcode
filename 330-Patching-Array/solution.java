public class Solution {
    public int minPatches(int[] nums, int n) {
        int cur = 0;
        int maxReach = 0;
        int res = 0;
        for(int i = 1; i > 0 && i <= n; i = maxReach + 1){
            if(cur < nums.length && maxReach >= nums[cur] - 1){
                maxReach += nums[cur];
                cur++;
            }
            else {
                maxReach += i;
                res++;
            }
        }
        return res;
    }
    /*
    每次计算最大能达到多少，然后i是当前要达到的数，若在nums里或者nums里下一个数已经在可达到的范围内了，则可到达到的范围加上nums里当前的数变成了新的可达到的范围，然后下一个要找的数是当前可达到范围加1.
若nums里的数已经遍历光了，或nums里的当前的数大于大于要找的数，则需要加一个数。


至于为什么下一个可达到的范围等于上一个可达到的范围加上要找的数呢，是因为上一个可达到的范围已经之内所有的数已经能被其他数表示了。要找的数总比上一个可达到的范围大1，否则就不需要找或达不到。
    */
}