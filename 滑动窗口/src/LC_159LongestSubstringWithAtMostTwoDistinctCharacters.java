import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 */
public class LC_159LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len < 3) return len;

        int left = 0, right = 0, ans = 2;
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            if (map.size() < 3) {
                map.put(s.charAt(right), right++);
            }
//            else {
//                int index = Collections.min(map.values());
//                map.remove(s.charAt(index));
//                left = index + 1;
//            }
            if (map.size() == 3) {
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                left = index + 1;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LC_159LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
