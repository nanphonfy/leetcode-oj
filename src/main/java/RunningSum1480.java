/**
 * @author nanphonfy(南风zsr)
 * @date 2020/8/23
 */
public class RunningSum1480 {
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        int lastSum = 0;
        for (int i = 0; i < nums.length; i++) {
            lastSum = lastSum + nums[i];
            arr[i] = lastSum;
        }
        return arr;
    }

    public int[] runningSumByLeetCode(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
