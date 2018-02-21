package facetime;

/**
 * Created by yujian on 2018/2/21.
 */
public class ListIntersect {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p=headA;
        ListNode q=headB;
        int length1=0;
        int length2=0;
        int diff=0;
        while(p!=null){
            length1++;
            p=p.next;
        }
        while(q!=null){
            length2++;
            q=q.next;
        }
        if(length1>length2){
            p=headA;
            q=headB;
            diff=length1-length2;
        }
        else{
            p=headB;
            q=headA;
            diff=length2-length1;
        }
        for(int i=0;i<diff;i++){
            p=p.next;
        }
        while(p!=null&&q!=null){
            if(p.equals(q)){
                return p;
            }
            p=p.next;
            q=q.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


