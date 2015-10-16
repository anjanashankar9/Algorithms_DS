/**
 * Created by ashankar1 on 10/16/15.
 */

/**
 * A Singly Linked List node
 */
class ListNode{
    int value;
    ListNode next;

    ListNode(int val){
        this.value = val;
        this.next = null;
    }
}
public class LinkedList {
    public static void main(String[] args){
        ListNode head = createList(10);
        printList(head);
        System.out.println();
        findMid(head);
        ListNode reversedList = reverseList(head);
        printList(reversedList);
        System.out.println();
    }

    /**
     * Creates a list of n elements
     * @param n number of elements in the list
     * @return head of the list
     */
    private static ListNode createList(int n) {
        ListNode head = new ListNode(1);
        ListNode last = head;
        for(int i=2;i<n+1;i++){
            last.next = new ListNode(i);
            last = last.next;
        }
        return head;
    }

    /**
     * Prints the linked list
     * @param head
     */
    private static void printList(ListNode head){
        ListNode current = head;
        while(current!=null) {
            System.out.print(current.value+" ");
            current = current.next;
        }
    }

    /**
     * Reverse the linkedlist
     * @param head linked list to be reversed
     * @return head of the reversed linked list
     */
    private static ListNode reverseList(ListNode head){
        ListNode prev = head;
        ListNode current = head.next;
        ListNode temp = null;
        prev.next = null;
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    /**
     * Finds the middle element of the given linked list
     * @param head linked list
     * @return the middle node of the linked list
     */
    private static ListNode findMid(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Mid point "+slowPtr.value);
        return slowPtr;
    }
}
