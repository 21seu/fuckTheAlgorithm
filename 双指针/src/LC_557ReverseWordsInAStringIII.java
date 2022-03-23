/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 */
public class LC_557ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                sb.append(s.charAt(start + i - p - 1));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new LC_557ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest");
    }
}
