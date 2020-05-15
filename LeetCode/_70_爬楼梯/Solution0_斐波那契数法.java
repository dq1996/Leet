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
 * 斐波那契数列，F(n) = F(n - 1) + F(n - 2)，直接使用递归将超时，使用循环计数。
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution0_斐波那契数法 {
	
	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int first = 1;
		int second = 2;
		int stairs = 0;
		for (int i = 3; i <= n; i ++) {
			stairs = first + second;
			first = second;
			second = stairs;
		}
		return stairs;
    }
	public static void main(String[] args) {
		int n = 3;
		int stairs = climbStairs(n);
		System.out.println(stairs);
	}

}
