public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        int[] father = new int[nums.length];
        int[] map = new int[nums.length];
        int maxIndex = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length; i++){
            int curmax = 0;
            father[i] = i;
            for(int j = 0; j < i; j++){
                if(map[j] > curmax && nums[i] % nums[j] == 0) {
                    curmax = map[j];
                    father[i] = j;
                }
            }
            map[i] = curmax + 1;
            if(map[i] > max) {
                max = map[i];
                maxIndex = i;
            }
        }
        while(father[maxIndex] != maxIndex) {
            res.add(0, nums[maxIndex]);
            maxIndex = father[maxIndex];
        }
        res.add(0, nums[maxIndex]);
        return res;
        
    }
    /*
    典型的选择型dp 类似于decode way，但是在记录路径的时候运用了union find中的find big father的思想

用map记录以i为最大元素的子divisible 集合的长度。
    */
}