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

//时间复杂度O(n)、空间复杂度O(n)
public class Solution0_递归 {
	public static ListNode reverseList(ListNode head) {
	    if (head == null || head.next == null) {
	    	return head;
	    }
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
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
