package LeetCode._面试题_10_01_合并排序的数组;

import java.util.Arrays;

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
 * 直接把B放入A的后n位，并排序。
 * 
 * 时间复杂度O(nlogn)、空间复杂度O(logn)
 */
public class Solution0_直接合并排序法 {

	public static void merge(int[] A, int m, int[] B, int n) {
		for (int i = 0; i < n; i ++) {
			A[m + i] = B[i];
		}
		Arrays.sort(A);
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
