package LeetCode._1_两数之和;

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

//时间复杂度O(n^2)、空间复杂度O(1)
public class Solution0_暴力法 {
	public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					index[0] = i;
					index[1] = j;
					return index;//new int[] {i, j}
				}
			}
		}
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] index = twoSum(nums, target);
		System.out.print("[" + index[0] + "," + index[1] + "]");
	}
}
