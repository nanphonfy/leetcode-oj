import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author nanphonfy(南风zsr)
 * @date 2020/8/22
 */
public class SimpleTest {
    @Test
    public void twoSum1Test(){
        TwoSum1 twoSum = new TwoSum1();
        int[] nums ={2, 7, 11, 15};
        int[] result = twoSum.twoSum3(nums,9);
        Assert.assertArrayEquals(result,new int[]{0,1});
    }
    @Test
    public void addTwoNumbers2Test(){
        AddTwoNumbersNew2 addTwoNumbers2 = new AddTwoNumbersNew2();

        // 9,9999999991
        /*ListNode lv3_1 = new ListNode(9);
        ListNode lv3_2 = new ListNode(1);
        ListNode c = null;
        for(int i =0;i<9;i++){
            if(c == null){
                c = new ListNode(9);
                lv3_2.next = c;
            }else{
                c.next = new ListNode(9);
                c = c.next;
            }
        }*/
        // 243,564
        /*ListNode lv3_1 = new ListNode(2);
        lv3_1.next = new ListNode(4);
        lv3_1.next.next = new ListNode(3);
        ListNode lv3_2 = new ListNode(5);
        lv3_2.next = new ListNode(6);
        lv3_2.next.next = new ListNode(4);*/
        ListNode lv3_1 = new ListNode(0);
        ListNode lv3_2 = new ListNode(0);

        System.out.println(new Gson().toJson(addTwoNumbers2.addTwoNumbers(lv3_1,lv3_2)));
    }

    @Test
    public void runningSum1480Test(){
        RunningSum1480 runningSum1480 = new RunningSum1480();
        int[] arr = {3,1,2,10,1};
        System.out.println(new Gson().toJson(runningSum1480.runningSum(arr)));
    }

    @Test
    public void kidsWithCandies1431Test(){
        KidsWithCandies1431 kidsWithCandies1431 = new KidsWithCandies1431();
        int[] arr = {12,1,12};
        int num = 10;
/*
        int[] arr = {2,3,5,1,3};
        int num = 3;
*/
        System.out.println(new Gson().toJson(kidsWithCandies1431.kidsWithCandies(arr,3)));
    }
}
