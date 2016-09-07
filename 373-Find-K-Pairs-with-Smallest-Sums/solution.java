public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(k == 0 || nums1.length == 0 || nums2.length == 0) return res;
        int[] idx = new int[nums1.length];
        
        while(k-- > 0){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i = 0; i < idx.length;i++){
                if(idx[i] < nums2.length && min > nums1[i] + nums2[idx[i]]){
                    min = nums1[i] + nums2[idx[i]];
                    minIndex = i;
                }
            }
            if(idx[minIndex] < nums2.length){
                res.add(new int[]{nums1[minIndex], nums2[idx[minIndex]]});
                idx[minIndex]++;
            }
            if(min == Integer.MAX_VALUE) break;
        }
        return res;
    }
    /*
    两种解法：
1.用一个数组idx[i] = j 来表示在数组1中第一个元素对应的是数组二中第j个元素。每次遍历数组找出数组1中的元素的值加上数组2中元素的值的和的最小值然后把他加进结果。当数组二到达数组2的长度的时候我们把忽略。
2. 思路和解法1类似，区别是用最小堆来找最小值每次，堆得元素是一个tuple其中包含数组1的index和数组2的index外加两个的和，每次该元素成为最小的时候把他加进数组然后数组2中的index加1.
    */
}