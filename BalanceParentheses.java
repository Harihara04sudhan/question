public class BalanceParentheses {
    public static void main(String[] args) {
        String input = "((ab)(c))(()";
        System.out.println(removeUnbalanced(input));
    }

    static String removeUnbalanced(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] valid = new boolean[n];

        // Mark all as valid initially
        for (int i = 0; i < n; i++) valid[i] = true;

        // Pass 1: Left to right - remove extra ')'
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                open++;
            } else if (chars[i] == ')') {
                if (open > 0) {
                    open--;
                } else {
                    // invalid ')'
                    valid[i] = false;
                }
            }
        }

        // Pass 2: Right to left - remove extra '('
        open = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                open++;
            } else if (chars[i] == '(') {
                if (open > 0) {
                    open--;
                } else {
                    // invalid '('
                    valid[i] = false;
                }
            }
        }

        // Build final string manually
        char[] result = new char[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (valid[i]) {
                result[index++] = chars[i];
            }
        }

        // Convert to string manually
        String output = "";
        for (int i = 0; i < index; i++) {
            output += result[i];
        }

        return output;
    }
}
