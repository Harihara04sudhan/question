public class ZohoPattern {
    public static void main(String[] args) {
        String word = "ZOHOCORPORATION";
        int n = 0;

        // Calculate length manually without using .length()
        try {
            while (true) {
                word.charAt(n);
                n++;
            }
        } catch (Exception e) {
            // end of string
        }

        // Create X pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || j == n - i - 1) {
                    System.out.print(word.charAt(i));
                } else {
                    System.out.print(" ");
                }
                // else if (j == n - i - 1) {
                //     System.out.print(word.charAt(j));
                // } 
               
            }
            System.out.println();
        }
    }
}
