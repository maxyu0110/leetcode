public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int indexEnd = nums.length - 1;
        int indexStart = 0;
        while(start <= end) {
            int startVal = getVal(nums[start], a, b, c);
            int endVal = getVal(nums[end], a, b, c);
            if(a >= 0){
                if(startVal > endVal){
                    res[indexEnd--] = startVal;
                    start++;
                }
                else {
                    res[indexEnd--] = endVal;
                    end--;
                }
            }
            else {
                if(startVal > endVal){
                    res[indexStart++] = endVal;
                    end--;
                }
                else {
                    res[indexStart++] = startVal;
                    start++;
                }
                
            }
            
        }
        return res;
    }
    
    public int getVal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    /*
    本题的难点在于想抛物线的形状，从而得出2 pointer的解法，一个从左走一个从右走，当a >=0 时抛物线是凹的，所以只要比较两边的点的大小来决定谁是大的放在结果的后面，当 a < 0 时，抛物线是凸的，所以可以从两边得出较小的结果放在开始
    */
}