package com.vathevor.javalgo.linkedlist;

/*
 * Sort a linked list using insertion sort.
 *
 * Algorithm of Insertion Sort:
 *      1. Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 *      2. At each iteration, insertion sort removes one element from the input data,
 *         finds the location it belongs within the sorted list, and inserts it there.
 *      3. It repeats until no input elements remain.
 */
public class InsertionSortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode headOfResult = new ListNode(0);
        ListNode currentNode = head;
        ListNode nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;

            ListNode iteratorNode = headOfResult;
            while (iteratorNode.next != null && iteratorNode.next.val < currentNode.val) {
                iteratorNode = iteratorNode.next;
            }

            currentNode.next = iteratorNode.next;
            iteratorNode.next = currentNode;
            currentNode = nextNode;
        }

        return headOfResult.next;
    }
}
