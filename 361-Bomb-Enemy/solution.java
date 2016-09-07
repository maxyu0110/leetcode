public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rowSum= 0;
        int[] colSums = new int[grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(j == 0 || grid[i][j - 1] == 'W'){
                    rowSum = 0;
                    for(int k = j; k < grid[0].length && grid[i][k] != 'W'; k++){
                        rowSum += grid[i][k] == 'E'? 1 : 0;
                    }
                }
                if( i == 0 || grid[i - 1][j] == 'W') {
                    colSums[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++){
                        colSums[j]+= grid[k][j] == 'E'? 1 : 0;;
                    }
                }
                if(grid[i][j] == '0'){
                    max = Math.max(max, colSums[j] + rowSum);
                }
            }
        }
        return max;
    }
    /*
    dp解法是遍历三遍。 第一遍从左上走到右下，第二遍从右下走到左上，第三遍找出最大值
左上遍历到右下：dp[i][j] = dp[i][i - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
dp[i][j]表示上左到上个墙的e的个数
dp不对！！！！！！！！！！



最好的解法是memoization:
把grid分成行和列分成section，以wall来划分，两个wall之间的值只需要计算一次，其他的共享就好了。brute force的方法之所以是(mn(m+n))是因为每一个点都要遍历行和列，这样有共享的话，其实每个点只需要遍历2遍最多。

步骤：
对于每一个点rowcache记录当前的行section里有多少个enemy，colcache 记录当前的列section里有多少个enemy，因为是针对行的，所以rowcache只需要变量就好，而列是需要1维数组。
当i = 0 或者j = 0时需要初始化，不管是行还是列，因为上一个没墙所以没有需要计算。如果数组里没墙则数组直接得出结果。
当i != 0 或者 j != 0时则需要判断上一个是否为墙，如果是，则需计算到下一个row和col的墙为止这一个section的值。

    */
}