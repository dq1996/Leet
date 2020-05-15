package LeetCode._169_多数元素;

import java.util.HashMap;
import java.util.Map;

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

//时间复杂度O(n)、空间复杂度O(n)
public class Solution0_哈希表法 {
	public static int majorityElement(int[] nums) {
		int len = nums.length;
		//将（元素，元素出现次数）对存入哈希表
		Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
		for (int num : nums) {
			//第一次出现置1
			if (! numCount.containsKey(num)) {
				numCount.put(num, 1);
			}
			else {
				//此处不能用++
				numCount.put(num, numCount.get(num) + 1);
			}
		}
		//更巧妙的遍历键值对方法
		for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
			if (entry.getValue() >= len / 2 + 1) {
				return entry.getKey();
			}
		}
		throw new IllegalArgumentException("No majority element");
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 3};
		int num = majorityElement(nums);
		System.out.println(num);
	}
}
