public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String part1 = words[i].substring(0, j);
                String part2 = words[i].substring(j);
                if(isPalindrome(part1)) {
                    String part2Rev =  new StringBuffer(part2).reverse().toString();
                    if(map.containsKey(part2Rev) && i != map.get(part2Rev)){
                        addPair(res, map.get(part2Rev),i);
                    }
                }
                
                if(isPalindrome(part2)) {
                    String part1Rev=  new StringBuffer(part1).reverse().toString();
                    if(map.containsKey(part1Rev) && i != map.get(part1Rev) && part2.length() != 0){
                        addPair(res, i, map.get(part1Rev));
                    }
                }
            }
        }
        return res;
    }
    private void addPair(List<List<Integer>> res, int i, int j){
        List<Integer> cur = new ArrayList<>();
        cur.add(i);
        cur.add(j);
        res.add(cur);
    }
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    /*
    O(n*k2)
如果两个词可以组成回文，只有两种情况，word1可以被分成两部分part1 和part2，
1. part1是回文，part2的反转在map里且不是word1： word2 + word1
2. part2是回文，且part1的反转在map里且不是word1： word1 + word2 （注意当word2长度为零时不要再加了，因为第一种情况已经加过了）

    */
}