package LeetCode._169_多数元素;

import java.util.Random;

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
 * 多数元素占了一半或一半以上，随机选择一个元素就有很大概率是多数元素。
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution2_随机化法 {
	
	//计算一个数在数组中的出现次数
	private static int calNumCount(int[] nums, int num) {
		int count = 0;
		for (int n : nums) {
			if (n == num) {
				count ++;
			}
		}
		return count;
	}
	
	public static int majorityElement(int[] nums) {
		//建立随机数对象
		Random rand = new Random();
		//如果上一次不能返回，则不断用新的随机数试探
		while (true) {
			//获取随机下标，在数组长度范围随机取一个整数
			int randomIndex = rand.nextInt(nums.length);
			int count = calNumCount(nums, nums[randomIndex]);
			if (count > nums.length / 2) {
				return nums[randomIndex];
			}
		}
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		int num = majorityElement(nums);
		System.out.println(num);
	}
}
