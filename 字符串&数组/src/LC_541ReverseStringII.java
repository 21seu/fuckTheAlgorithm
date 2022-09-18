/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class LC_541ReverseStringII {

    public String reverseStr(String s, int k) {
        int len = s.length();
        int part = len / (2 * k);
        int part_part = len % (2 * k);
        part_part = (part_part >= k && part_part < 2 * k) ? k : part_part;
        int start = 0;
        while (part-- > 0) {
            s = reverse(s, start, start + k - 1);
            start += (2 * k);
        }
        return part_part != 0 ? reverse(s, start, start + part_part - 1) : s;
    }

    /**
     * 优化写法
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        int len = s.length();
        for (int i = 0; i < len; i+= 2 * k) {
            s = reverse(s, i, Math.min(len, i + k) - 1);
        }
        return s;
    }

    private String reverse(String s, int start, int end) {
        char[] chArr = s.toCharArray();
        while (start <= end) {
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;
            start++;
            end--;
        }
        return new String(chArr);
    }

    public static void main(String[] args) {
        new LC_541ReverseStringII().reverseStr("abcd", 2);
    }
}
