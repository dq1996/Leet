package LeetCode._440_字典序的第K小数字;

import java.util.Scanner;

/*
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 注意：1 ≤ k ≤ n。
 * 
 *输入:
 *n: 13   k: 2
 *
 *输出:
 *10
 *
 *解释:
 *字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 */

/*
 * 数据结构：十叉树
 * 算法：
 * 1、确定一个前缀下所有子节点的个数（用下一个前缀的起点减去当前前缀的起点）；
 * 2、确定第k个数所在的前缀（从0前缀开始用k减掉其子节点个数）；
 * 3、若第 k 个数在当前的前缀下，从前往后找k--；
 */
public class Main {
	//通过用下一个前缀的起点减去当前前缀的起点得到当前前缀下所有子节点的个数
	private static int calChildNodeCountOfCurPrefixNum(int maxNum, long curPrefixNum, long nextPrefixNum) {
		int childNodeCountOfCurPrefixNum = 0;
		while (curPrefixNum <= maxNum) {
			//maxNum的与10的余数也应该加上
			childNodeCountOfCurPrefixNum += Math.min(maxNum + 1, nextPrefixNum) - curPrefixNum;
			curPrefixNum *= 10;
			nextPrefixNum *= 10;
		}
		return childNodeCountOfCurPrefixNum;
	}
	
	private static int getKThSmallerNum(int maxNum, int dictionaryOrderIndex) {
		int kThSmallerNum = 1;
		dictionaryOrderIndex --;//减去第一个数的占位
		int childNodeCountOfCurPrefixNum = 0;//在当前前缀下的子节点个数
		while (dictionaryOrderIndex > 0) {
			//得到当前前缀下所有子节点的个数
			childNodeCountOfCurPrefixNum = calChildNodeCountOfCurPrefixNum(maxNum, kThSmallerNum, kThSmallerNum + 1);
			if (dictionaryOrderIndex >= childNodeCountOfCurPrefixNum) {
				dictionaryOrderIndex -= childNodeCountOfCurPrefixNum;
				kThSmallerNum ++;
			}
			else {//跨越十叉树层
				dictionaryOrderIndex --;
				kThSmallerNum *= 10;
			}
		}
		return kThSmallerNum;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maxNum = input.nextInt();
		int dictionaryOrderIndex = input.nextInt();
		input.close();
		
		int kThSmallerNum = getKThSmallerNum(maxNum, dictionaryOrderIndex);
		System.out.println(kThSmallerNum);
	}

}
