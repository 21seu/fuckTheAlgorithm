/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 输入: nums = [0]
 * 输出: [0]
 */
public class LC_283MoveZeroes {
    public void moveZeroes(int[] nums) {
        //做本题之前可以看下LC27题
//        int slow = 0;
//        int n = nums.length;
//        for (int fast = 0; fast < n; fast++) {
//            if (nums[fast] != 0) {
//                nums[slow] = nums[fast];
//                slow++;
//            }
//        }
//        while (slow < n) {
//            nums[slow] = 0;
//            slow++;
//        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                reverse(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void reverse(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        new LC_283MoveZeroes().moveZeroes(arr);
    }
}
