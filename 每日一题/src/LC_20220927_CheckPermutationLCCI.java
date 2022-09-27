import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_20220927_CheckPermutationLCCI {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < s1.length(); i++) {
            if (ch1[i] != ch2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new LC_20220927_CheckPermutationLCCI().CheckPermutation("abc","bab");
    }
}
