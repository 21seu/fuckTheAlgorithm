import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class LC_34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int res = binarySearch(nums, target);
        if (res == -1) return new int[]{-1, -1};
        int left = res, right = res;
        //左边界
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        //右边界
        while (right + 1 <= nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        new LC_34FindFirstAndLastPositionOfElementInSortedArray().searchRange(arr, 8);
    }
}
