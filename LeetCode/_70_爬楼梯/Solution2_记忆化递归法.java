package LeetCode._70_爬楼梯;

/*
 * 假设你正在爬楼梯。
 * 需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。
 * 你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：
 * 给定 n 是一个正整数。
 * 
 * 示例 1：
 * 输入： 
 * 2
 * 
 * 输出：
 * 2
 * 
 * 解释：
 * 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 输入： 
 * 3
 * 
 * 输出： 
 * 3
 * 
 * 解释： 
 * 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

/*
 * 思路：
 * 使用函数模拟爬1阶和2阶的可能情形，使用数组保存递归中间结果。
 * 
 * 树形递归时间复杂度O(n)、递归树的深度空间复杂度O(n)
 */
public class Solution2_记忆化递归法 {
	private static int climbStairsInRange(int start, int end, int[] result) {
		if (start > end) {
			return 0;
		}
		//保存叶子节点中刚好到终点的路径个数
		if (start == end) {
			return 1;
		}
		//返回中间结果，这一步使时间减半，不返回没有结果的路径，否则超时
		if (result[start] > 0) {
			return result[start];
		}
		//使用result数组来保存每一次递归返回的结果
		result[start] = climbStairsInRange(start + 1, end, result) + climbStairsInRange(start + 2, end, result);
		//返回最后结果
		return result[start];
	}
	public static int climbStairs(int n) {
		int[] result = new int[n];
		return climbStairsInRange(0, n, result);
	}
	public static void main(String[] args) {
		int n = 3;
		int stairs = climbStairs(n);
		System.out.println(stairs);
	}
}
