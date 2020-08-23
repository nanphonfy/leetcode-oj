class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 输入：
 * [5]
 * [5]
 * 输出：
 * [0]
 * 预期：
 * [0,1]
 */
public class AddTwoNumbersNew2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode result = null;
        ListNode current = null;
        // 进位
        int carry = 0;

        while ((p != null || q != null) || carry > 0) {
            p = (p != null) ? p : new ListNode(0);
            q = (q != null) ? q : new ListNode(0);

            int sum = p.val + q.val + carry;

            carry = sum > 9 ? 1 : 0;
            if (current == null) {
                result = new ListNode(sum % 10);
                current = result;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            p = p.next;
            q = q.next;
        }
        return result;
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersByLeetCode(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
