/*
题目描述

输入一个链表，输出该链表中倒数第k个结点。
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public static ListNode FindKthToTail(ListNode head,int k) {
    	ListNode tem = head;
    	int flag = 0;
    	if(k==0)
    		return null;
    	for(int i=1; i<k; i++){
    		if(head.next!=null)
    			head = head.next;
    		else
    			return null;
    	}
    	while(head.next!=null){
    		head = head.next;
    		flag++;
    	}
    	for(int i=1; i<flag+1; i++){
    		tem = tem.next;
    	}
    	return tem;
    }
    public static void main(String [] args){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	System.out.println(FindKthToTail(n1,3));
    }
}
/*
1.从头开始记录下k个数字，然后在记录k个数字之后还有几个数字，
2.程序鲁棒性问题，特别是对于具有指向的问题，首先想到的就是对其边界进行一些处理。
*/