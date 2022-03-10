import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 输入: [1,2,3,4]
 * 输出: false
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class LC_217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) throw new RuntimeException("数组元素不能为空！！！");
        /*Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            map.put(nums[i], 1);
        }
        return false;*/
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
