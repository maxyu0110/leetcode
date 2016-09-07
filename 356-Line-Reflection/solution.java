public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0) return true;
        int minX = points[0][0];
        int maxX = points[0][0];
        HashSet<Integer> set = new HashSet<>();
        for(int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            set.add(Arrays.hashCode(point));
        }
        int midLine = minX + maxX;
        for(int[] point : points) {
            if(!set.contains(Arrays.hashCode(new int[] {midLine - point[0], point[1]}))) {
                return false;
            }
        }
        return true;
    }
    /*
    注意这道题特像2sum。
两种做法：
1. 最好的做法，midLine = (minX + maxX) / 2 = (point[x] + reflectPoint[x])/2 所以 2俩边抵消。所以用一个hashset 来记录所有的点的hash值然后在遍历一遍所有points找到是否其映射点在set里，注意不能用原始的array的hashcode，Arrays.hashCode.
2. 排序然后2 pointer从两边向中间遍历。
    */
}