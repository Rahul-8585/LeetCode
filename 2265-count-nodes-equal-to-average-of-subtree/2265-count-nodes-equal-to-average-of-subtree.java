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

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // returns {sum, count}
    private int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        // Get sum and count of left subtree
        int[] left = dfs(node.left);

        // Get sum and count of right subtree
        int[] right = dfs(node.right);

        // Calculate current subtree sum
        int sum = left[0] + right[0] + node.val;

        // Calculate current subtree node count
        int count = left[1] + right[1] + 1;

        // Calculate average
        int average = sum / count;

        // Check if node value equals average
        if (node.val == average) {
            ans++;
        }

        // Return sum and count to parent
        return new int[]{sum, count};
    }
}