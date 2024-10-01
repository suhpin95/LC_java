package edu.example.linkedList;

public class Solution {
    /**
     * Reverse LinkedList
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        // Dummynode concept
        ListNode prevNode = new ListNode(0), current = head;
        while(current != null) {
            ListNode nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        return prevNode;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
