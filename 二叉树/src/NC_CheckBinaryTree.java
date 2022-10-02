import sun.reflect.generics.tree.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.nowcoder.com/questionTerminal/f31fc6d3caf24e7f8b4deb5cd9b5fa97
 * 给定一棵二叉树，已知其中的节点没有重复值，请判断该二叉树是否为搜索二叉树和完全二叉树。
 * 输出描述：分别输出是否为搜索二叉树、完全二叉树。
 * 数据范围：二叉树节点数满足 0 \le n \le 5000000≤n≤500000 ，二叉树上的值满足 0 \le val \le 1000000≤val≤100000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * 注意：空子树我们认为同时符合搜索二叉树和完全二叉树。
 */
public class NC_CheckBinaryTree {

    private long pre = Long.MIN_VALUE;

    public ArrayList<Boolean> judgeIt(TreeNode root) {
        // write code here
        ArrayList<Boolean> res = new ArrayList<>();
        res.add(bfs(root));
        res.add(dfs(root));
        return res;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        if (!dfs(root.left)) return false;
        if (root.val < pre) return false;
        pre = root.val;
        return dfs(root.right);
    }

    private boolean bfs(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (flag && curr != null)
                    return false;
                if (curr == null)
                    flag = true;
                queue.offer(curr.left);
                queue.offerFirst(curr.right);
            }
        }
        return true;
    }
}
