package LeetCode._1_两数之和;

import java.util.HashMap;
import java.util.Map;

/*
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素不能使用两遍。
 * 
 * 示例:
 * 输入：
 * nums = [2, 7, 11, 15], target = 9
 * 
 * 输出：
 * [0, 1]
 */

//哈希表将查找时间缩短到 O(1)，所以时间复杂度O(n)、空间复杂度O(n)
public class Solution1_两遍哈希表法 {
	public static int[] twoSum(int[] nums, int target) {
		//将（数组元素，-下标）对存入哈希表
        Map<Integer, Integer> element_Index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			element_Index.put(nums[i], i);
		}
        //从小下标重新开始
        for (int i = 0; i < nums.length; i++) {
        	int rest = target - nums[i];
        	//在哈希表中查找另一个数，就算有后来的相同的数，下标也覆盖了不是原来的
        	//注意：不能查找自己本身！
			if (element_Index.containsKey(rest) && element_Index.get(rest) != i) {
				return new int[] {i, element_Index.get(rest)};
			}
		}
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 3};
		int target = 6;
		int[] index = twoSum(nums, target);
		System.out.print("[" + index[0] + "," + index[1] + "]");
	}
}
