public class PalLinkedList {
	// Time: O(n), space: O(1)
	// First,reverse first half of the linkedlist.Then compare the two list from the middle. 
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int i = 0;
        //Get the length of the list
        while (p.next != null) {
            p = p.next;
            i++;
        }
        boolean isEven = i % 2 == 0;
        i = i/2;
        p = dummy;
        //reverse the first half of the list
        while (i != 0) {
            ListNode tmp = head.next;
            head.next = p;
            p = head;
            head = tmp;
            i--;
        }
        if (!isEven) {
            head = head.next;
        }
        //check if the two list are palindrome
        while (head != null) {
            if (head.val == p.val) {
                head = head.next;
                p = p.next;
            } else {
                return false;
            }
        }
        return true;
    }
}