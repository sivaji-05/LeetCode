/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth= getDepth(root, true);
        int rightDepth= getDepth(root , false);
        if(leftDepth == rightDepth){
            return (1 << leftDepth)-1;
        }
        return 1+ countNodes(root.left) + countNodes(root.right);        
        
    }
    private int getDepth(TreeNode node, boolean isleft){
        int depth= 0 ;
        while (node != null){
            depth++;
            node = isleft ? node.left : node.right;
        }
        return depth;
    }
}