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

/*
 * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
 * 如果它存在，那我们已经找到了对应解，并立即将其返回。
 * 
 * 哈希表将查找时间缩短到 O(1)，所以时间复杂度O(n)、空间复杂度O(n)
 */
public class Solution2_一遍哈希表法 {
	public static int[] twoSum(int[] nums, int target) {
		//将（数组元素，-下标）对存入哈希表
        Map<Integer, Integer> element_Index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			int rest = target - nums[i];
        	//在哈希表中查找另一个数
        	//注意：不能查找自己本身！
			//从大下标开始，小下标未保存
			if (element_Index.containsKey(rest)) {
				//此处i将是较大的下标，rest在较小下标对应的数中进行查找
				return new int[] {element_Index.get(rest), i};
			}
			element_Index.put(nums[i], i);//存入放在判断之后可以省略判断本身
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
