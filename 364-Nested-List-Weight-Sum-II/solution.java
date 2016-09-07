/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0;
        int sum = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger n : nestedList){
            q.offer(n);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            for(int i = 0; i < size;i++){
                NestedInteger cur = q.poll();
                if(cur.isInteger()) {
                    levelSum += cur.getInteger();
                }
                else {
                    q.addAll(cur.getList());
                }
            }
            sum += levelSum;
            res += sum;
        }
        return res;
    }
}