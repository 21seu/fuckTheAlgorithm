/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */
public class LC_509FibonacciNumber {

    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        int dp_0 = 0, dp_1 = 1;
        for (int i = 2; i <= n; i++) {
            int dp_i = dp_0 + dp_1;
            dp_0 = dp_1;
            dp_1 = dp_i;
        }
        return dp_1;
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) return n;

        int[] dp = new int[n];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[n - 2] + dp[n - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LC_509FibonacciNumber().fib(4));
    }
}
