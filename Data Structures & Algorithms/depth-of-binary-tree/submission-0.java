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
    int maxDepth = 0;
    Deque<TreeNode> queue = new ArrayDeque<>();
    int count;

    public int maxDepth(TreeNode root) {
        /**
        * The idea with BFS is you iteratively search through the tree
        * So you start at the root add its children into the queue, and
        * then keep popping the queue until you've explored all nodes
        * exploration is done across the tree rather than straight down
        * So to keep track of the height you need to pop the number of
        * children associated with the parents above
        * i.e. if I'm currrently on level k, level I need to pop the number
        * of nodes on this level based on the number of children the parent
        * nodes had in level k - 1
        */

        if (root == null) {
            return 0;
        } else {
            queue.add(root);
            count = 1;
        }

        while (!queue.isEmpty()) {
            int numChildren = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) {
                    queue.add(node.left);
                    numChildren++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    numChildren++;
                }
            }
            maxDepth++;
            count = numChildren;
        }

        return maxDepth;
    }
}
