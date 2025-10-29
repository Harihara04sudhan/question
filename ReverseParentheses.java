public class ReverseParentheses {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));        // Output: dcba
        System.out.println(reverseParentheses("a(b(cd)e)f")); // Output: zohocorp
    }

    public static String reverseParentheses(String s) {
        char[] stack = new char[s.length()];  // manual stack
        int top = -1; // stack pointer

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                // Pop until '(' found and store in temp array
                char[] temp = new char[s.length()];
                int tempIndex = 0;

                while (top >= 0 && stack[top] != '(') {
                    temp[tempIndex++] = stack[top--]; // pop characters
                }

                // Pop '(' itself
                if (top >= 0 && stack[top] == '(') {
                    top--;
                }

                // Push the reversed (already reversed) temp chars back
                for (int j = 0; j < tempIndex; j++) {
                    stack[++top] = temp[j];
                }

            } else {
                // Just push the character
                stack[++top] = ch;
            }
        }

        // Build final result from stack
        String result = "";
        for (int i = 0; i <= top; i++) {
            result += stack[i];
        }

        return result;
    }
}
