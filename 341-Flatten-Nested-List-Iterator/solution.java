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
public class NestedIterator implements Iterator<Integer> {
    
    private List<NestedInteger> nestedList;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            NestedInteger cur = nestedList.remove(0);
            return cur.getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(nestedList.size() == 0){
            return false;
        }
        NestedInteger cur = nestedList.remove(0);
        if(cur.isInteger()) {
            nestedList.add(0, cur);
            return true;
        }
        else {
            List<NestedInteger> curList = cur.getList();
            nestedList.addAll(0,  curList);
            return hasNext();
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */