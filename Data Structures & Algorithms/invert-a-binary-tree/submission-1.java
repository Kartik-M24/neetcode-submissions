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
    Deque<TreeNode> queue = new ArrayDeque<>();
    int count;

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            TreeNode nodeLeft = node.left;;
            TreeNode nodeRight = node.right;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right!= null) {
                queue.add(node.right);
            }
            node.left = nodeRight;
            node.right = nodeLeft;
        }

        return root;
    }
}
