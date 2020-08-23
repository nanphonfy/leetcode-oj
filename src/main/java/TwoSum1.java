import java.util.HashMap;
import java.util.Map;

/**
 * @author nanphonfy(南风zsr)
 * @date 2020/8/22
 */
public class TwoSum1 {
    /**
     * 方法一：暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j) {
                    boolean flag = nums[i] + nums[j] == target;
                    if (flag) {
                        return new int[] { i, j };
                    }
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：两遍哈希表(空间换速度)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int self = target - nums[i];
            if (map.containsKey(self) && map.get(self) != i) {
                return new int[] { i, map.get(self) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表(空间换速度)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int self = target - nums[i];
            // 循环肯定不会跟自己遇到
            if (map.containsKey(self)) {
                // 【注意】map在第一次判断时并不存在，所以得逆序
                return new int[] {map.get(self),i };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
