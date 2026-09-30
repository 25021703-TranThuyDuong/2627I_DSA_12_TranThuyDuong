//Week 3
import java.util.Stack;

public class BalancedBrackets {
    static boolean areBracketsBalanced(String expr) {

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);


            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }


            if (x == ')' || x == ']' || x == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char check = stack.pop();
                switch (x) {
                    case ')':
                        if (check == '{' || check == '[')
                            return false;
                        break;

                    case '}':
                        if (check == '(' || check == '[')
                            return false;
                        break;

                    case ']':
                        if (check == '(' || check == '{')
                            return false;
                        break;
                }
            }
        }


        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String expr = "([{}])";

        if (areBracketsBalanced(expr))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}