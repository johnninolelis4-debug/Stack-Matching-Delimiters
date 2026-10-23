
import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    public static boolean checkDelimiters(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                System.out.println("Read: " + ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                System.out.println("Read: " + ch);

                if (stack.isEmpty()) {
                    System.out.println("Invalid: Closing delimiter "
                            + "has no matching opening delimiter.");
                    return false;
                }

                char top = stack.peek();
                System.out.println("Operation: PEEK " + top);

                if (!isMatching(top, ch)) {
                    System.out.println("Invalid: Mismatched delimiters. "
                            + "Expected a closing delimiter for " + top
                            + " but found " + ch + ".");
                    return false;
                }

                stack.pop();
                System.out.println("Operation: POP " + top);
                System.out.println("Stack: " + stack);
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Invalid: Unmatched opening delimiter "
                    + "remains in the stack: " + stack);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence: ");
        String input = scanner.nextLine();

        boolean valid = checkDelimiters(input);

        if (valid) {
            System.out.println("Result: Valid");
        } else {
            System.out.println("Result: Invalid");
        }

        scanner.close();
    }
}
