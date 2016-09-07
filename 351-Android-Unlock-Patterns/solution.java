public class Solution {
    public int numberOfPatterns(int m, int n) {
        if(m > n || n <= 0 || m > 9){
            return 0;
        }
        boolean[] visit = new boolean[10];
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = skip[9][1] = skip[1][9] = skip[3][7] = skip[7][3] = 5;
        int res = 0;
        for(int i = m ; i <= n; i++){
            res += dfs(visit, skip, 1, i) * 4;
            res += dfs(visit, skip, 2, i) * 4;
            res += dfs(visit, skip, 5, i);
        }
        return res;
    }
    
    public int dfs(boolean[] visit, int[][] skip, int cur, int remain){
        if(remain <= 1){
            return remain;
        }
        visit[cur] = true;
        int res = 0;
        for(int i = 1; i <= 9 ; i++){
            if(!visit[i] && (skip[cur][i] == 0 || visit[skip[cur][i]])){
                res += dfs(visit, skip, i, remain - 1);
            }
           
        }
        visit[cur] = false;
        return res;
    }
    /*
    1， 3， 7， 9是对称的，2，4，6，8是对称的，外加一个5
用一个二维矩阵记录一下哪些格子中间有其他的格子，
用一个一维矩阵记录哪些点被访问过

    */
}