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
 * Binets法
 * 二维数组q = {{1, 1}, {1, 0}}
 * 根据公式，第n个斐波那契数Fn = q ^ n的第0行第0列的数字
 * 
 * 时间复杂度O(logn)、空间复杂度O(1)
 */
public class Solution4_Binets法 {
	
	//公式计算Fn = q ^ n
	private static int[][] matrixPow(int[][] q, int n) {
		int[][] temp = q;//记录原始q
		for (int i = 0; i < n - 1; i ++) {
			q = matrixSelfMultiply(q, temp);//q = q * q ^ (n - 1)
		}
		return q;
	}
	
	//矩阵乘法
	private static int[][] matrixSelfMultiply(int [][] a, int[][] b) {
		int[][] res = new int[2][2];
		for (int i = 0; i < 2; i ++) { 
			for (int j = 0; j < 2; j ++) {
				res[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];//i前j后，从0到1
			}
		}
		return res;
	}
	
	public static int climbStairs(int n) {
		int[][] q = {{1, 1}, {1, 0}};
		int[][] resMatrix = matrixPow(q, n);
		int methodCount = resMatrix[0][0];//第n个斐波那契数Fn = q ^ n的第0行第0列的数字
		return methodCount;
	}
	public static void main(String[] args) {
		int n = 3;
		int stairs = climbStairs(n);
		System.out.println(stairs);
	}
}
