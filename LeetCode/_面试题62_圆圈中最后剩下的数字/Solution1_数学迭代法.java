package LeetCode._面试题62_圆圈中最后剩下的数字;

/*
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 
 * 示例 1：
 * 输入: 
 * n = 5, m = 3
 * 
 * 输出:
 * 3
 * 
 * 示例 2：
 * 输入: 
 * n = 10, m = 17
 * 
 * 输出: 
 * 2
 * 
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */

/*
 * 思路：
 * 改写为迭代，避免递归使用栈空间
 * f(n,m) = (m + f(n-1,m)) % n
 * 给定一个长度为n的序列，每次向后数m个元素并删除
 * f(n,m)为最后留下的数的下标，但从0开始的数组中下标与数值相等
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution1_数学迭代法 {

	public static int lastRemaining(int n, int m) {
		int nextIndex = 0;
		for (int i = 2; i <= n; i ++) {
			nextIndex = (m + nextIndex) % i;
		}
		return nextIndex;
    }
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		System.out.println(lastRemaining(n, m));
	}
}
