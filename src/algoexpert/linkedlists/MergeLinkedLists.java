package algoexpert.linkedlists;

public class MergeLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node mergeLists(Node head1, Node head2) {
        Node prev1 = null, p1 = head1, p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                prev1 = p1;
                p1 = p1.next;
            } else {
                if (prev1 != null) {
                    prev1.next = p2;
                }
                prev1 = p2;
                p2 = p2.next;
                prev1.next = p1;
            }
        }

        if (p1 == null) {
            prev1.next = p2;
        }


        return (head1.data < head2.data) ? head1 : head2;

    }



}
