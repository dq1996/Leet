package LeetCode._206_反转链表;

/*
 * 反转一个单链表。
 * 
 * 示例:
 * 输入: 
 * 1->2->3->4->5->NULL
 * 
 * 输出: 
 * 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 用迭代或递归两种方法。
 */

//时间复杂度O(n)、空间复杂度O(1)
public class Solution1_迭代 {
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;//保存前置节点
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode newHead = reverseList(head);
		System.out.print(newHead.val);
		while (newHead != null && newHead.next != null) {
			System.out.print("->" + newHead.next.val);
			newHead = newHead.next;
		}
		System.out.print("->NULL");
	}
}
