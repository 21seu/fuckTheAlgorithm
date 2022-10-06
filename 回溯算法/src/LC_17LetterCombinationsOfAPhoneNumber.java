import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LC_17LetterCombinationsOfAPhoneNumber {

    private String[] model = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        dfs(digits, 0, len);
        return res;
    }

    StringBuffer sb = new StringBuffer();
    private void dfs(String digits, int begin, int len) {
        //回溯终止
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        //for循环
        for (int i = begin; i < len; i++) {
            int index = digits.charAt(i) - '0';
            for (char ch : model[index].toCharArray()) {
                sb.append(ch);
                System.out.println("回溯前====> "+ sb);
                dfs(digits, i + 1, len);
                sb.deleteCharAt(sb.length() - 1);
                System.out.println("回溯后====> "+ sb);
            }
        }
    }

    public static void main(String[] args) {
        new LC_17LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }
}
