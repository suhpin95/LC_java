package edu.example.linkedList;

public class Solution {
    /**
     * Reverse LinkedList
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // Dummynode concept
        ListNode prevNode = new ListNode(0), current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        return prevNode;
    }

    /**
     * reOrder List
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slowPtr = head, fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        // reverse The secondHalf
        ListNode secondHalf = slowPtr.next, prev = null;
        slowPtr.next = null;
        while (secondHalf != null) {
            ListNode nextNode = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = nextNode;
        }
        ListNode firstHalf = head;
        secondHalf = prev;
        while (secondHalf != null) {
            ListNode temp1, temp2;
            temp1 = firstHalf.next;
            temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    /**
     * Remove Nth Node from end
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPtr = head;
        for (int i = 0; i < n; i++) {
            fastPtr = fastPtr.next;
        }
        if(fastPtr == null)return head.next;
        ListNode slowPtr = head;
        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        slowPtr.next = slowPtr.next != null ? slowPtr.next.next : slowPtr.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
