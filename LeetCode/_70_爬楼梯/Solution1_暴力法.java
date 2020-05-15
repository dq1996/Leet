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
 * 使用函数模拟爬1阶和2阶的可能情形。
 * 
 * 树形递归时间复杂度O(2^n)、递归树的深度空间复杂度O(n)
 * 复杂度太大超时。
 */
public class Solution1_暴力法 {
	private static int climbStairsInRange(int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		return climbStairsInRange(start + 1, end) + climbStairsInRange(start + 2, end);
	}
	public static int climbStairs(int n) {
		return climbStairsInRange(0, n);
	}
	public static void main(String[] args) {
		int n = 3;
		int stairs = climbStairs(n);
		System.out.println(stairs);
	}
}
