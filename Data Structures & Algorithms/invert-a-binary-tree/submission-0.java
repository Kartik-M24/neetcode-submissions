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
            count = 1;
        }

        while (!queue.isEmpty()) {
            int numChildren = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.pop();
                TreeNode nodeLeft = null;
                TreeNode nodeRight = null;

                if (node.left != null) {
                    nodeLeft = node.left;
                    queue.add(node.left);
                    numChildren++;
                }
                if (node.right!= null) {
                    nodeRight = node.right;
                    queue.add(node.right);
                    numChildren++;
                }
                node.left = nodeRight;
                node.right = nodeLeft;
            }
            count = numChildren;
        }

        return root;
    }
}
