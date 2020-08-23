import com.google.gson.Gson;

/**
 * 【错误案例 by20.08.23】
 * int型，会因为数字太大，爆掉
 * 手动改为long型可以支撑更多案例，但oi不准确
 * @author nanphonfy(南风zsr)
 * @date 2020/8/22
 */
/*执行结果：
解答错误
显示详情
输入：
[9]
[1,9,9,9,9,9,9,9,9,9]
输出：
[8,0,4,5,6,0,0,1,4,1,1,1]
预期结果：
[0,0,0,0,0,0,0,0,0,0,1]

输入：
[0]
[0]
输出：
[]
预期：
[0]*/
class ListNodeNanfy {
    long val;
    ListNodeNanfy next;

    ListNodeNanfy(long x) {
        val = x;
    }
}

public class AddTwoNumbers2 {
    public ListNodeNanfy addTwoNumbers(ListNodeNanfy l1, ListNodeNanfy l2) {
        long sum1 = getSumByNode(l1);
        long sum2 = getSumByNode(l2);
        long sum = sum1 + sum2;

        if(sum == 0){
            return new ListNodeNanfy(0);
        }

        // 计算总共有几位数
        long base = 1;
        int count = 0;
        while (sum / base > 0) {
            base *= 10;
            count++;
        }

        // 把值逆序存入数组
        base = 1;
        // 807
        long[] arr = new long[count];
        for(int i=0;i<count;i++){
            arr[i] = sum/base%10;
            base *= 10;
        }

        // 将数组赋值给单向链表
        ListNodeNanfy current = null;
        ListNodeNanfy result = null;
        for (int i = 0; i<count; i++) {
            ListNodeNanfy tmpl = new ListNodeNanfy(arr[i]);

            if (null == current) {
                current = tmpl;
                result = current;
            } else {
                current.next = tmpl;
                current = current.next;
            }
        }
        return result;
    }

    private static long getSumByNode(ListNodeNanfy l1) {
        long sum = 0;
        long base = 1;
        while (l1 != null) {
            sum += (l1.val * base);
            l1 = l1.next;

            base *= 10;
        }
        return sum;
    }

    //(2 -> 4 -> 3) + (5 -> 6 -> 4)
    public static void main(String[] args) {
        ListNodeNanfy l1 = new ListNodeNanfy(2);
        ListNodeNanfy l1_1 = new ListNodeNanfy(4);
        ListNodeNanfy l1_2 = new ListNodeNanfy(3);

        ListNodeNanfy l2 = new ListNodeNanfy(5);
        ListNodeNanfy l2_1 = new ListNodeNanfy(6);
        ListNodeNanfy l2_2 = new ListNodeNanfy(4);

        l1.next = l1_1;
        l1_1.next = l1_2;

        l2.next = l2_1;
        l2_1.next = l2_2;

        ListNodeNanfy lv2_1 = new ListNodeNanfy(0);
        ListNodeNanfy lv2_2 = new ListNodeNanfy(0);

        ListNodeNanfy lv3_1 = new ListNodeNanfy(9);
        ListNodeNanfy lv3_2 = new ListNodeNanfy(1);
        ListNodeNanfy c = null;
        for(int i =0;i<9;i++){
            if(c == null){
                c = new ListNodeNanfy(9);
                lv3_2.next = c;
            }else{
                c.next = new ListNodeNanfy(9);
                c = c.next;
            }
        }

        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        Gson gson = new Gson();
        System.out.println(gson.toJson(addTwoNumbers2.addTwoNumbers(lv3_1,lv3_2)));
    }
}
