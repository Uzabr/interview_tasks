package algo_task_2;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class IsValid {

    public static void main(String[] args) {
        String s = "()[]";
        System.out.println(isValid_2(s));

    }

    // первый способ
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //второй способ

    private static boolean isValid_2(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
