public class Solution {
    public String rearrangeString(String str, int k) {
        int[] map = new int[26];
        int[] lastPos = new int[26];
        for(int i = 0; i < str.length(); i++){
            map[str.charAt(i) - 'a']++;
            lastPos[str.charAt(i) - 'a'] = -1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            int cur = getMaxValidChar(map, lastPos, k, i);
            if(cur < 0) return "";
            map[cur]--;
            lastPos[cur] = i;
            sb.append((char)(cur + 'a'));
        }
        return sb.toString();
    }
    
    public int getMaxValidChar(int[]map, int[]lastPos, int k, int index) {
        int max = Integer.MIN_VALUE;
        int res = -1;
        for(int i = 0; i < map.length; i++){
            if(map[i] > 0 && max < map[i] && (index - lastPos[i] >= k || lastPos[i] < 0)) {
                max = map[i];
                res = i;
            }
        }
        return res;
    }
    /*
    用贪心算法，每次选择当前数量最多且valid的字符放到当前位置，若果没有则说明不能rearrange。
所以我们既要用map来记录每个字母出现了多少次，还要用lastpos记录每个字母上一次出现的位置，以判断当前字母是不是valid。
lastpos一定要初始化为-1，否则为零的话，可能第一个进不去。
    */
}