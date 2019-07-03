package com.vathevor.javalgo.linkedlist;

import com.vathevor.javalgo.linkedlist.InsertionSortList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InsertionSortListTest {

    private InsertionSortList underTest = new InsertionSortList();

    @Test
    void testCase1() {
        int[] input = {4, 2, 1, 3};
        test(input);
    }

    @Test
    void testCase2() {
        int[] input = {-1, 5, 3, 4, 0};
        test(input);
    }

    private void test(int[] input) {
        ListNode headOfInput = createList(input);

        ListNode headOfResult = underTest.insertionSortList(headOfInput);

        ListNode currentNode = headOfResult;
        while (currentNode.next != null) {
            assertTrue(currentNode.val < currentNode.next.val);
            currentNode = currentNode.next;
        }
    }

    private ListNode createList(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode current = head;
        for (int i = 1; i < numbers.length; i++) {
            ListNode next = new ListNode(numbers[i]);
            current.next = next;
            current = next;
        }
        return head;
    }
}