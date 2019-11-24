public class Forth {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p;
        ListNode q;
        if(headA == null || headB == null){
            return null;
        }
        p = headA;
        q = headB;
        while(p != q) {
            if(p == null) {
                p = headB;
            }else{
                p = p.next;
            }

            if(q == null) {
                q = headA;
            }else{
                q = q.next;
            }
        }
        return p;
    }
}
