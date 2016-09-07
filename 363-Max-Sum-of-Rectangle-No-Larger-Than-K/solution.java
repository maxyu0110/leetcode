public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            int[] sum = new int[matrix.length];
            for(int j = i; j < matrix[0].length; j++){
                for(int r = 0; r < matrix.length; r++){
                    sum[r] += matrix[r][j];
                }
                TreeSet<Integer> set = new TreeSet<>();
                int curSum = 0;
                set.add(0);
                for(int cur : sum){
                    curSum += cur;
                    Integer upperBound = set.ceiling(curSum - k);
                    if(upperBound != null) {
                        max = Math.max(curSum - upperBound, max);
                    }
                    set.add(curSum);
                }
            }
        }
        return max;
    }
    /*
    首先，最基本的算法是n4，需要找到每一个左上方的点和右下方的点，然后计算子矩阵的和。（mn）^2
其次是kadane算法。固定左右两个列i，j，然后计算一个累积数组，这个数组每一行从i 到 j的该行的累计值。用max sum from sub array来找这个。
最后是最有效的算法。kadane结合从subarray中找不大于k的最大和。既然是curSum[q] - curSum[p] 要小于 k，
所以 curSum【q】- k < curSum[p]
所以我们用一个treeset来记录之前所有的累计值，然后每次从treeset里查找是否有大于她的最小值。

    */
}