package LeetCode._169_多数元素;

import java.util.Arrays;

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
 * 将数组进行排序，排在中间的一定是多数元素
 * 
 * 时间复杂度O(nlogn)（将数组排序）、空间复杂度O(logn)
 * （使用语言自带的排序算法，需要O(logn)的栈空间。
 * 如果自己编写堆排序，则只需要使用O(1)的额外空间。）
 */
public class Solution1_排序法 {
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		int num = majorityElement(nums);
		System.out.println(num);
	}
}
