public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if(nodes[0].equals("#")) return nodes.length == 1;
        int diff = 2;
        for(int i = 1; i < nodes.length; i++){
            if(diff <= 0) return false;
            if(!nodes[i].equals("#")){
                diff++;
            }
            else diff--;
        }
        return diff == 0;
    }
    /*
    按照preorder + "#"的形式进行序列化，整个树一定是full的二叉树(non- leaves = leaves - 1). 且最终整个树的初度一定等于入度（对于任意树都是这样）。且在遍历完数组之前，如果合法，这个树的出度一定会大于入度。因为当出度等于入度的是时候，说明以上的遍历过的数已经可以组成一个合法的树了，所以叶子节点已经满了，所以之后再进入数的话，就会被加到叶子节点下面，所以就不合法了。所以只有最后等于零才合法。

每一个非叶子，非根，节点会贡献的diff = outdegree - indegree == 1 
每一个叶子节点贡献的diff = -indegree = -1;
根节点贡献的diff = outdegree == 2;
根节点如果是null则，diff = outdegree == 0;

不合法的情况只有两种：
1. 不是树，也就是树没有完。
2.  节点在n"#"下
    */
}