import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengtj on 2022/4/15 23:23
 */
public class LC_438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        Map<Character, Integer> m1 = new HashMap();
        Map<Character, Integer> m2 = new HashMap();
        for (char ch : p.toCharArray()) {
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char ch_right = s.charAt(right++);
            if (m1.containsKey(ch_right)) {
                m2.put(ch_right, m2.getOrDefault(ch_right, 0) + 1);
                if (m2.get(ch_right).equals(m1.get(ch_right))) {
                    count++;
                }
            }

            while (right - left >= p.length()) {
                if (count == m1.size()) {
                    list.add(left);
                }
                char ch_left = s.charAt(left++);
                if (m1.containsKey(ch_left)) {
                    if (m2.get(ch_left).equals(m1.get(ch_left))) {
                        count--;
                    }
                    m2.put(ch_left, m2.getOrDefault(ch_left, 0) - 1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new LC_438FindAllAnagramsInAString().findAnagrams("baa", "aa");
    }
}
