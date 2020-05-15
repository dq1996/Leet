package LeetCode._292_Nim游戏;

/*
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * 桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 你作为先手。
 * 你们是聪明人，每一步都是最优解。
 * 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * 
 * 示例:
 * 输入: 
 * 4
 * 
 * 输出: 
 * false 
 * 
 * 解释: 
 * 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */

/*
 * 脑筋急转弯：
 * 想要自己赢，不能面对4的倍数的石头
 * 想要对手输，拿取一定数目的石头使剩下的石头为4的倍数
 * 
 * 结论：
 * 当你的回合，石头数目为4的倍数时，永远不会赢得比赛。
 * 
 * 时间复杂度O(1)、空间复杂度O(1)
 */
public class Solution {
	public static boolean canWinNim(int n) {
		if (n % 4 == 0) {
			return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		boolean ifWin = canWinNim(4);
		System.out.println(ifWin);
	}

}
