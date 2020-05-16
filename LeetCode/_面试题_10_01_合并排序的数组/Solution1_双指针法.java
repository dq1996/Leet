package LeetCode._面试题_10_01_合并排序的数组;

/*
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: 
 * [1,2,2,3,5,6]
 * 
 * 说明:
 * A.length == n + m
 */

/*
 * 思路：
 * 1、新建与A同等大小的数组sorted；
 * 2、新建A和B的下标指针；
 * 3、新建curNum用于保存当前应放入sorted的值；
 * 4、注意遍历时边界；
 * 5、将sorted复制给A。
 * 
 * 时间复杂度O(n)、空间复杂度O(n)
 */
public class Solution1_双指针法 {

	public static void merge(int[] A, int m, int[] B, int n) {
		int[] sorted = new int[m + n];
		int pa = 0;
		int pb = 0;
		int curNum = 0;
		while (pa < m || pb < n) {
			if (pa == m) {
				curNum = B[pb];
				pb ++;
			}
			else if (pb == n) {
				curNum = A[pa];
				pa ++;
			}
			else if (A[pa] <= B[pb]) {
				curNum = A[pa];
				pa ++;
			}
			else if (A[pa] > B[pb]) {
				curNum = B[pb];
				pb ++;
			}
			sorted[pa + pb - 1] = curNum;
		}
		for (int i = 0; i < m + n; i ++) {
			A[i] = sorted[i];
		}
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] B = {2, 5, 6};
		int n = 3;
		merge(A, m, B, n);
		for (int num : A) {
			System.out.print(num + " ");
		}
	}

}
