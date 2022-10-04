import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]] 
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class LC_77Combinations {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new LinkedList<>();
        dfs1(n, k, 1, path);
        return res;
    }

    private void dfs1(int n, int k, int begin, Deque<Integer> path) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs1(n, k, i + 1, path);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    /**
     * 减枝优化dfs
     * @param n
     * @param k
     * @param begin
     * @param path
     */
    private void dfs2(int n, int k, int begin, Deque<Integer> path) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        //上界 + 剩余要选的个数 - 1 = n => 上界 = n + 1 - (k - path.size())
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs1(n, k, i + 1, path);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        LC_77Combinations solution = new LC_77Combinations();
        int n = 5;
        int k = 3;
        List<List<Integer>> res = solution.combine(n, k);
        System.out.println(res);
    }
}
