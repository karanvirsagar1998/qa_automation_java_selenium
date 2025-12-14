import java.util.ArrayDeque;
import java.util.Deque;

public class palindrome {
    public static void main(String[] args) {
        int[][] palindromeTestCases = { { 994 }, { 121 }, { 1221 }, { 1 }, { 0 }, { 11 }, { 12321 },
                { 12 }, { 123 }, { 1231 }, { 10 }, { 100 }, { 12021, 0 } };
        for (int[] test : palindromeTestCases) {
            int input = test[0];
            Deque<Integer> box = new ArrayDeque<>();
            int temp = input;
            while (temp > 0) {
                box.addLast(temp % 10);
                temp = temp / 10;
            }
            boolean isPalindrome = true;
            while (box.size() > 1) {
                if (box.removeFirst() != box.removeLast()) {
                    isPalindrome = false;
                    break;
                }
                temp /= 10;
            }
            System.out.println("Input->" + input + ", " + isPalindrome);
        }
    }
}
