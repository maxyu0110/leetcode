public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        if(updates.length == 0) return res;
        for(int[] u : updates){
            res[u[1]] +=  u[2];
            if(u[0] != 0) {
                res[u[0] - 1] += -u[2];
            }
        }
        int sum = 0;
        for(int i = res.length - 1; i >= 0; i--){
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
    /*
    更新（1，3，2）相当于更新（0，3，2）和（0，0，-2）
直接更新结果数组，然后从后往前相加。
    */
}