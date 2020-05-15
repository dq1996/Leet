package LeetCode._169_多数元素;

/*
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ （取下界）的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 示例 1:
 * 输入: 
 * [3,2,3]
 * 
 * 输出:
 * 3
 * 
 * 示例 2:
 * 输入: 
 * [2,2,1,1,1,2,2]
 * 
 * 输出: 
 * 2
 */

/*
 * 不断将数组分为两个区间，多数元素必定是某一个区间的多数元素。
 * 直至区间长度为1，计算区间内的多数元素
 * 再回溯合并在较大区间内，这两个区间长度为1的多数元素，比较哪个是上层较大区间的多数元素
 * 直至最大区间的多数元素
 * 
 * 二分时间复杂度O(nlogn)、在递归的过程中使用了额外的栈空间，空间复杂度O(logn)
 */
public class Solution3_分治法 {
	
	//计算一个数在数组区间中的出现次数
	private static int calNumCountInRange(int[] nums, int num, int low, int high) {
		int count = 0;
		for (int i = low; i <= high; i ++) {
			if (nums[i] == num) {
				count ++;
			}
		}
		return count;
	}
		
	private static int majorityElementInRange(int[] nums, int low, int high) {
		if (low == high) {
			return nums[low];
		}
		int mid = (low + high) / 2;
		//把区间不断分成左右两个区间，直至区间长度为1，计算区间内的多数元素
		//再回溯合并在较大区间内，这两个区间长度为1的多数元素，哪个是上层较大区间的多数元素
		//直至最大区间的多数元素
		int left = majorityElementInRange(nums, low, mid);
		int right = majorityElementInRange(nums, mid + 1, high);
		int leftCount = calNumCountInRange(nums, left, low, high);
		int rightCount = calNumCountInRange(nums, right, low, high);
		if (leftCount > rightCount) {
			return left;
		}
		else {
			return right;
		}
    }
	public static int majorityElement(int[] nums) {
		return majorityElementInRange(nums, 0, nums.length - 1);
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		int num = majorityElement(nums);
		System.out.println(num);
	}
}
