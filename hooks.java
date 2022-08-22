
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
import java.util.Stack;

public class hooks {
    public static void main(String[] args) {
        String s = "()}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')' && s.charAt(i) != ']' && s.charAt(i) != '}') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
}
