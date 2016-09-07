/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, new HashMap<>());
    }
    
    public int helper(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int max = 0;
        int ll = root.left == null? 0 : helper(root.left.left, map);
        int lr = root.left == null? 0 : helper(root.left.right, map);
        int rl = root.right == null? 0 : helper(root.right.left, map);
        int rr = root.right == null? 0 : helper(root.right.right, map);
        int option1 = root.val + ll + lr + rl + rr;
        int option2 = helper(root.left, map) + rr + rl;
        int option3 = helper(root.right, map) + ll + lr;
        int option4 = helper(root.left, map) + helper(root.right, map);
        //max = Math.max(option1, Math.max(option2, Math.max(option3, option4)));
        max = Math.max(option1, option4);
        map.put(root, max);
        return max;
    }
    /*
    option4包含了option2 和 option3， 因为option4不是local，而是global，还记得股票4那道题吗？
    */
}