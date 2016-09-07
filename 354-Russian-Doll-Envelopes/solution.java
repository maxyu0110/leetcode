public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length <= 1) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int max = 1;
        int[] map = new int[envelopes.length];
        map[0] = 1;
        for(int i = 1; i < envelopes.length; i++) {
            int cur = 0;
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    cur = Math.max(cur, map[j]);
                }
            }
            map[i] = cur + 1;
            max = Math.max(max, map[i]);
        }
        return max;
    }
}