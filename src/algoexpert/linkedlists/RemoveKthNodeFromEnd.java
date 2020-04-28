package algoexpert.linkedlists;

public class RemoveKthNodeFromEnd {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList curr = head, ref = head;
        int c = 1;
        while (ref != null && c <= k) {
            ref = ref.next;
            c++;
        }
        if (ref == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (ref.next != null) {
            ref = ref.next;
            curr = curr.next;
        }

        curr.next = curr.next.next;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
