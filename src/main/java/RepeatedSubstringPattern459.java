/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
 * @author nanphonfy(南风zsr)
 * @date 2020/8/24
 */
public class RepeatedSubstringPattern459 {
    /**
     * 题目理解错了，以为子串相加必等于母串，实际上是包含关系 by200825
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {

        char[] subArr = new char[s.length() / 2];
        for (int i = 0; i < s.length() / 2; i++) {
            // 子串
            subArr[i] = s.charAt(i);

            //  子串是否重复一次以上
            int count = 0;
            for (int j = i + 1; j < s.length(); j++) {
                boolean isSubStr = false;
                // 是否为子串
                for (int k = 0; k <= i; k++) {
                    int idx = j % (i + 1);
                    if (idx == k && s.charAt(j) == subArr[k]) {
                        isSubStr = true;
                        break;
                    }
                }
                if (isSubStr) {
                    count++;
                } else {
                    count = 0;
                }
            }
            if (count >= 1) {
                return true;
            }
        }

        return false;
    }


    /**
     * 花了半天学习了KMP，至于题解...不重要，反正我也想不到方法二。
     * 还是网友的解释牛逼：https://www.zhihu.com/question/21923021，
     * 还可以看这个视频作参考https://www.bilibili.com/video/av81151415?p=1 。
     * 算法第四版
     * ——需要系统学下KMP算法
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern1ByLeetCode(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            // 重复子串必完整构成字符串
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    // ......KMP算法解法未完待续

    public static void main(String[] args) {
        RepeatedSubstringPattern459 repeatedSubstringPattern459 = new RepeatedSubstringPattern459();

        // aba不算
        //        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abab"));
        //        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("ababab"));
        //        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abcabcabcabc"));
//        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("aabaaba"));
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("aabaaba"));
        //        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("bb"));
    }
}
