package LeetCode._256_粉刷房子;

/*
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种。
 * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * 每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；
 * costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请你计算出粉刷完所有房子最少的花费成本。
 * 
 * 注意：
 * 所有花费均为正整数。
 * 
 * 示例：
 * 输入: 
 * [[17,2,17],[16,16,5],[14,3,19]]
 * 
 * 输出: 
 * 10
 * 
 * 解释: 
 * 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 * 最少花费: 2 + 5 + 3 = 10。
 */

/*
 * 思路：
 * 动态规划，一层层取所有可能结果的最小值，直至最后一层的最小值
 * 
 * 时间复杂度O(n)，空间复杂度O(n^2)
 */
public class Solution {
	
	public static int minCost(int[][] costs) {
		int minCost = 0;
		int n = costs.length;
		//dp要n + 1的原因是：将初始化dp[0][0] = costs[0][0]，dp[0][1] = costs[0][1],dp[0][2] = costs[0][2]合并到循环中
		int[][] dp = new int[n + 1][3];
		for (int i = 1; i < n + 1; i ++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
		}
		//Math.min函数只能同时计算两个值
		minCost = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
		return minCost;
    }
	
	public static void main(String[] args) {
		int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
		int minCost = minCost(costs);
		System.out.println(minCost);
	}

}
