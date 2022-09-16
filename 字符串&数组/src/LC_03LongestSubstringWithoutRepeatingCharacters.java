import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LC_03LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (s.length() == 0) return ans;
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!queue.isEmpty() && queue.contains(s.charAt(i))) {
                queue.removeLast();
            }
            queue.addFirst(s.charAt(i));
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_03LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcbca"));
    }
}
