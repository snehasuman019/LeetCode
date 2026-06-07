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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        // Step 1: Build nodes and connect
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];
            
            // Get or create parent node
            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            map.put(parentVal, parent);
            
            // Get or create child node
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));
            map.put(childVal, child);
            
            // Connect parent → child
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            // Track child
            children.add(childVal);
        }
        
        // Step 2: Find root (not in children set)
        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }
        
        return null; // should never happen if input is valid
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
