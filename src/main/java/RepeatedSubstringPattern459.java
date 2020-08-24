/**
 * @author nanphonfy(南风zsr)
 * @date 2020/8/24
 */
public class RepeatedSubstringPattern459 {
    public boolean repeatedSubstringPattern(String s) {

        char[] subArr = new char[s.length() / 2];
        for (int i = 0; i < s.length() / 2; i++) {
            subArr[i] = s.charAt(i);

            int sameCount = -1;
            boolean flag = true;
            for (int j = i + 1; j < s.length(); j++) {
                // 是否为子串
                for (int k = 0; k <= i; k++) {
                    if (s.charAt(j%(i+1)) == subArr[k]) {
                        sameCount++;
                    }
                }
                if(sameCount == i){
                    sameCount = 0;
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern459 repeatedSubstringPattern459 = new RepeatedSubstringPattern459();
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("ababab"));
    }
}
