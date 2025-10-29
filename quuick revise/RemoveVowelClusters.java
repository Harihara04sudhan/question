public class RemoveVowelClusters {

    // Function to check if a character is a vowel (case-insensitive)
    static boolean isVowel(char c) {
        if (c == 'a' || c == 'A' ||
            c == 'e' || c == 'E' ||
            c == 'i' || c == 'I' ||
            c == 'o' || c == 'O' ||
            c == 'u' || c == 'U') {
            return true;
        }
        return false;
    }

    // Function to remove vowels and vowel clusters
    static String removeVowelClusters(String str) {
        char[] chars = str.toCharArray();
        String result = "";
        int i = 0;

        while (i < chars.length) {
            if (isVowel(chars[i])) {
                // Skip the entire vowel cluster
                while (i < chars.length && isVowel(chars[i])) {
                    i++;
                }
            } else {
                result += chars[i];
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "Beautiful cooperation";
        String output = removeVowelClusters(input);
        System.out.println("Original: " + input);
        System.out.println("Without vowels/clusters: " + output);
    }
}
