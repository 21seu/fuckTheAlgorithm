import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 快速排序：
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class LC912_SortAnArray {

    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left < INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int index = pratition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    /**
     * 插入排序
     *
     * @param nums
     * @param left
     * @param right
     *
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private int pratition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        new LC912_SortAnArray().findDuplicates(arr);
    }
}
