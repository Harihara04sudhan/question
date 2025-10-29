import java.util.Scanner;

public class ReverseConditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine().trim();
        sc.close();

        // Split manually (handle multiple spaces)
        String[] words = input.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            int position = i + 1; // 1-based position
            if (position % 2 == 0) { // reverse even-positioned words
                words[i] = reverseWord(words[i]);
            }
        }

        // Join manually
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i];
            if (i < words.length - 1)
                result += " ";
        }

        System.out.println("Output: " + result);
    }

    // Manual string reversal
    static String reverseWord(String word) {
        char[] chars = word.toCharArray();
        String rev = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            rev += chars[i];
        }
        return rev;
    }
}
