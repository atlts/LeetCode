class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode[] res = new ListNode[k + 2];//use res to store k nodes
        for (int i = 0; i <= k + 1; i++) res[i] = new ListNode(0);
        ListNode headNew = head, pre = head, p1 = head;
        //headNew record the new head,pre record the new chain's last code ,and p1 record the old chain's the first code.
        //Attention :the new chain means the new part of the origin chain and the old chain means the old one
        int cnt = 0, count = 1;
        res[1] = head;
        while (head != null) {
            if (count == k) {
                if (cnt == 0) {
                    cnt++;
                    p1 = head.next;
                    headNew = res[k];
                    pre = headNew;
                    for (int i = k - 1; i >= 1; i--) {
                        pre.next = res[i];
                        pre = pre.next;
                    }
                    head = pre;
                    pre.next = p1;
                    count = 0;
                } else {
                    cnt++;
                    p1 = head.next;
                    for (int i = k; i >= 1; i--) {
                        pre.next = res[i];
                        pre = pre.next;
                    }
                    head = pre;
                    pre.next = p1;

                    count = 0;
                }
            }
            head = head.next;
            res[++count] = head;
        }
        return headNew;
    }
}
