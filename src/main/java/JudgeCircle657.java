/**
 * @author nanphonfy(ÄÏ·çzsr)
 * @date 2020/8/28
 */
public class JudgeCircle657 {
    public boolean judgeCircle(String moves) {
        if (moves != null && moves.length() > 1) {
            int x = 0, y = 0;
            for (int i = 0; i < moves.length(); i++) {
                switch (moves.charAt(i)) {
                case 'R':
                    x += 1;
                    break;
                case 'L':
                    x += -1;
                    break;
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y += -1;
                    break;
                default:
                }
            }
            return x == 0 && y == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeCircle657 judgeCircle657 = new JudgeCircle657();
        System.out.println(judgeCircle657.judgeCircle("UD"));
        System.out.println(judgeCircle657.judgeCircle("LL"));
    }
}
