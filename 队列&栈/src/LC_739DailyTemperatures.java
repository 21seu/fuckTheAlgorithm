import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * 提示：
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class LC_739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int tmpIndex = stack.pop();
                res[tmpIndex] = i - tmpIndex;
            }
            stack.addFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        new LC_739DailyTemperatures().dailyTemperatures(nums);
    }
}
