import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class LC_131PalindromePartitioning {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        Deque<String> path = new LinkedList<>();
        dfs(s, 0, path);
        return res;
    }

    private void dfs(String s, int begin, Deque<String> path) {
        if (s.length() <= begin) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            if (check(s, begin, i)) {
                path.add(s.substring(begin, i + 1));
                System.out.println("回溯前====>" + path);
            } else {
                continue;
            }
            dfs(s, i + 1, path);
            path.removeLast();
            System.out.println("回溯后====>" + path);
        }
    }

    private boolean check(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        new LC_131PalindromePartitioning().partition("aab");
    }
}
