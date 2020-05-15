package LeetCode._892_三维形体的表面积;

/*
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 * 
 * 示例 1：
 * 输入：
 * [[2]]
 * 
 * 输出：
 * 10
 * 
 * 示例 2：
 * 输入：
 * [[1,2],[3,4]]
 * 
 * 输出：
 * 34
 * 
 * 示例 3：
 * 输入：
 * [[1,0],[0,2]]
 * 
 * 输出：
 * 16
 * 
 * 示例 4：
 * 输入：
 * [[1,1,1],[1,0,1],[1,1,1]]
 * 
 * 输出：
 * 32
 * 
 * 示例 5：
 * 输入：
 * [[2,2,2],[2,1,2],[2,2,2]]
 * 
 * 输出：
 * 46
 * 
 * 提示：
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */

/*
 * 思路：
 * 1、若网格上存在立方体，表面积+2；
 * 2、若邻近立方体不存在，邻近面积为网格上立方体的个数；
 * 3、若邻近立方体存在且该网格上立方体个数大于邻近网格立方体个数，邻近面积为该网格上立方体个数-邻近网格立方体个数；
 * 4、若邻近立方体存在且该网格上立方体个数大于邻近网格立方体个数，邻近面积为0。
 * 
 * 时间复杂度O(n ^ 2)、空间复杂度O(1)
 */
public class Solution {
	
	public static int surfaceArea(int[][] grid) {
		//网格为N*N
		int N = grid.length;
		//总表面积
		int area = 0;
		//这两个数组用来组合(i,j+1)、(i+1,j)、(i,j-1)、(i+1,j)
		int[] leftRight = {0, 1, 0, -1};
		int[] frontBack = {1, 0, -1, 0};
		//分别表示组合后的行和列下标
		int neighbourRow = 0;
		int neighbourColumn = 0;
		//遍历网格
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				if (grid[i][j] > 0) {
					//只要该网格存在立方体，就加上底层和顶层表面积各1
					area += 2;
					//寻找邻近立方体
					for (int k = 0; k < 4; k ++) {
						neighbourRow = i + leftRight[k];
						neighbourColumn = j + frontBack[k];
						//邻近节点必须在此处置0，因为余下的if和area+=对neighbour有不同要求
						int neighbour = 0;
						//若邻近立方体存在，表面积加上比邻近立方体大的邻近面积
						if (neighbourRow >= 0 && neighbourRow < N && 
							neighbourColumn >= 0 && neighbourColumn < N) {
							neighbour = grid[neighbourRow][neighbourColumn];
						}
						//若邻近立方体不存在，表面积加上该网格上立方体的数量
						area += Math.max(grid[i][j] - neighbour, 0);
					}
				}
			}
		}
		return area;
    }
	public static void main(String[] args) {
		int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
		int area = surfaceArea(grid);
		System.out.println(area);
	}
}
