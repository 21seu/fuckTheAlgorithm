import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class LC_78Subsets {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int begin, Deque<Integer> path) {
        res.add(new ArrayList<>(path));
        if (begin >= nums.length) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            System.out.println("递归前====>" + path);
            dfs(nums, i + 1, path);
            path.removeLast();
            System.out.println("递归后====>" + path);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new LC_78Subsets().subsets(nums);
    }
}
