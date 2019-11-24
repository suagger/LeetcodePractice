public class First {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headA = new ListNode(0);
        headA.next = head;
        ListNode first,second;
        first = headA;
        second = headA;
        for(int i = 1; i <= n + 1; i ++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return headA.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
