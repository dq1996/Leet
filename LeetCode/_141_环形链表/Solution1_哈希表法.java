package LeetCode._141_环形链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *  如果 pos 是 -1，则在该链表中没有环。
 *  
 *  示例 1：
 *  输入：
 *  head = [3,2,0,-4], pos = 1
 *  
 *  输出：
 *  true
 *  
 *  解释：
 *  链表中有一个环，其尾部连接到第二个节点。
 *  
 *  示例 2：
 *  输入：
 *  head = [1,2], pos = 0
 *  
 *  输出：
 *  true
 *  
 *  解释：
 *  链表中有一个环，其尾部连接到第一个节点。
 *  
 *  示例 3：
 *  输入：
 *  head = [1], pos = -1
 *  
 *  输出：
 *  false
 *  
 *  解释：
 *  链表中没有环。
 *  
 *  进阶：
 *  你能用 O(1)（即，常量）内存解决此问题吗？
 */

/*
 * 思路：
 * 用哈希表存储是否经过此节点
 * 
 * 时间复杂度O(n)，空间复杂度O(n)
 */
public class Solution1_哈希表法 {
	public static boolean hasCycle(ListNode head) {
		Set<ListNode> node = new HashSet<>();
		while (head != null) {
			if (! node.contains(head)) {
				node.add(head);
				head = head.next;
			}
			else {
				return true;
			}
		}
        return false;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		int pos = 1;
		boolean ifCycle = hasCycle(head);
		System.out.println(ifCycle);
	}
}
