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
 * 1、从后向前在A中插入正确元素；
 * 2、新建A和B的下标指针；
 * 3、新建tail控制A从后到前的下标；
 * 4、注意遍历时边界。
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution2_逆向双指针法 {

	public static void merge(int[] A, int m, int[] B, int n) {
		int pa = m - 1;
		int pb = n - 1;
		//保存取出来的那个插入元素十分重要！
		int curNum = 0;
		int tail = m + n - 1;
		while (pa >= 0 || pb >= 0) {
			//A先遍历完
			if (pa == -1) {
				curNum = B[pb];
				pb --;
			}
			else if (pb == -1) {
				curNum = A[pa];
				pa --;
			}
			else if (A[pa] >= B[pb]) {
				curNum = A[pa];
				pa --;
			}
			else if (A[pa] < B[pb]) {
				curNum = B[pb];
				pb --;
			}
			A[tail --] = curNum;
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
