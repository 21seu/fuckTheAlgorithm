import java.util.*;

/**
 * 插入排序
 * 思路：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
 */
public class InsertionSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

}
