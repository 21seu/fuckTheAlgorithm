/**
 * Created by fengtj on 2022/5/31 0:01
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
public class LC_20220530_1022SumOfRootToLeafBinaryNumbers {

    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int preSum) {
        if (root == null) return;
        preSum = preSum * 2 + root.val;
        if (root.left == null && root.right == null) {
            res += preSum;
        }
        dfs(root.left, preSum);
        dfs(root.right, preSum);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
