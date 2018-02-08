package medium;

/**
 * Created by yujian on 2017/9/13.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */


public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l11.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l21.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;

        ListNode head = addTwoNumbers(l11,l21);
        System.out.println(head.val+","+head.next.val+","+head.next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cursor = new ListNode(0);
        int l1_length = 1;
        int l2_length = 1;
        boolean flag = false;
        ListNode tmp_l1 = l1;
        while (tmp_l1.next!=null) {
            tmp_l1 = tmp_l1.next;
            l1_length++;
        }

        ListNode tmp_l2 = l2;
        while (tmp_l2.next!=null){
            tmp_l2 = tmp_l2.next;
            l2_length++;
        }

        for (int j=0;j<Math.max(l2_length,l1_length);j++){
            int result = l1.val+l2.val;
            ListNode listNode = new ListNode(0);
            ListNode l = new ListNode(1);
            if (flag) {
                if (result >= 9) {
                    flag = true;
                    listNode.val = result+1 - 10;
                } else {
                    flag = false;
                    listNode.val = result+1;
                }
            }
            else {
                if (result >= 10) {
                    flag = true;
                    listNode.val = result - 10;
                } else {
                    flag = false;
                    listNode.val = result;
                }
            }
            if (j==0) {
                head = listNode;
                cursor = listNode;
            }
            if (j!=0) {
                cursor.next = listNode;
            }
            cursor = listNode;
            if (j==Math.max(l2_length,l1_length)-1&&flag) {
                cursor.next = l;
            }
            l1 = l1.next==null?new ListNode(0):l1.next;
            l2 = l2.next==null?new ListNode(0):l2.next;
        }
        return head;
    }
}
