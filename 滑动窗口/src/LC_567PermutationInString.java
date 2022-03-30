import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false
 * 换句话说，s1 的排列之一是 s2 的 子串
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class LC_567PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) return false;

        int[] cur1 = new int[26];
        int[] cur2 = new int[26];
        for (char c : s1.toCharArray()) cur1[c - 'a']++;
        for (int i = 0; i < m; i++) cur2[s2.charAt(i) - 'a']++;
        if (checkArray(cur1, cur2)) return true;

        //滑动窗口
        for (int i = m; i < n; i++) {
            cur2[s2.charAt(i) - 'a']++;
            cur2[s2.charAt(i - n) - 'a']--;
            if (checkArray(cur1,cur2)) return true;
        }
        return false;
    }

    private boolean checkArray(int[] cur1, int[] cur2) {
        for (int i = 0; i < 26; i++) {
            if (cur1[i] != cur2[i]) return false;
        }
        return true;
    }
}
