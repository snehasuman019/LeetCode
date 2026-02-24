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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0); 
        } 
        private int dfs(TreeNode node, int curr) { 
            if (node == null) return 0;
             // Update current binary value
            curr = curr * 2 + node.val; 
            // If leaf node, return the current value 
            if (node.left == null && node.right == null) { 
                return curr; 
                } 
                // Otherwise, continue DFS on left and right 
                return dfs(node.left, curr) + dfs(node.right, curr); 
                
    }
}