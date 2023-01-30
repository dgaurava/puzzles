/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int l, int r) {
        if (lists.length < 1) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int m = (r + l) / 2;
        ListNode ln = merge(lists, l, m);
        ListNode rn = merge(lists, m + 1, r);
        return mergeLeftRight(ln, rn);
    }

    ListNode mergeLeftRight(ListNode ln, ListNode rn) {
        if (ln == null) {
            return rn;
        }
        if (rn == null) {
            return ln;
        }

        ListNode preln = new ListNode(0, ln);
        ListNode head = ln;
        ListNode oldhead = preln;

        while (head != null && rn != null) {
            if (head.val <= rn.val) {
                oldhead = head;
                head = head.next;
            } else {
                oldhead.next = rn;
                ListNode temp = rn.next;
                oldhead.next.next = head;
                rn = temp;
                oldhead = oldhead.next;
            }
        }

        while (rn != null) {
            oldhead.next = rn;
            rn = rn.next;
            oldhead = oldhead.next;
        }

        return preln.next;
    }

    public static class ListNode {
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
}