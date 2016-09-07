public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < s.length()) {
            if(map.size() < k || (map.size() == k && map.containsKey(s.charAt(end)))){
                if(!map.containsKey(s.charAt(end))){
                    map.put(s.charAt(end), 0);
                }
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                end++;
                max = Math.max(max, end - start);
            }
            else {
                if(map.get(s.charAt(start)) == 1) {
                    map.remove(s.charAt(start));
                }
                else {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }
                start++;
            }
        }
        return max;
        /*
        2 pointer;
维持一个size不超过k的hashmap，当size 等于k的时候判断下一个会不会因为size大于k，如果不会，就直接放，如果会则从start开始去除。

        */
    }
}