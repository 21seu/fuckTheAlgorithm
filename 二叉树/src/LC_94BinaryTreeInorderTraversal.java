import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class LC_94BinaryTreeInorderTraversal {

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    /**
     * Morris 遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
            }else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
