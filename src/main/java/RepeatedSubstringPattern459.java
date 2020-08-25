/**
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

    public boolean repeatedSubstringPattern2(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            boolean flag = false;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - i)) {
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern459 repeatedSubstringPattern459 = new RepeatedSubstringPattern459();

        // aba不算
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abab"));
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("ababab"));
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("aabaaba"));
    }
}
