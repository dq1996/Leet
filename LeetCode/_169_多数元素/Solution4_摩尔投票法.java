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
 * 数组中的多数元素出现时count ++，其他元素出现时--，采取多数元素与其他元素形成抵消效应
 * 由于多数元素占一半及以上，count非负。
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution4_摩尔投票法 {
	public static int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			if (candidate == num) {
				count ++;
			}
			else {
				count --;
			}
		}
		return candidate;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		int num = majorityElement(nums);
		System.out.println(num);
	}
}
