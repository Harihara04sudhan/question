public class CustomNumberSystem {

    // Returns the n-th number composed only of digits {3,4}
    // 1 -> "3", 2 -> "4", 3 -> "33", 4 -> "34", ...
    public static String nthNumber(long n) {
        if (n <= 0) return ""; // guard (problem assumes n >= 1)

        // Step 1: find length L such that sum_{i=1..L-1} 2^i < n <= sum_{i=1..L} 2^i
        long totalBefore = 0;    // sum of counts for lengths < L
        long countForLen = 2;    // count for current length (2^1 initially)
        int length = 1;

        while (totalBefore + countForLen < n) {
            totalBefore += countForLen;
            length++;
            // double countForLen for next length (2^length)
            countForLen = countForLen * 2;
            // (For very large n this may overflow; for typical contest limits it's fine)
        }

        // Step 2: offset inside this length block (0-based)
        long offset = n - totalBefore - 1; // 0 .. countForLen-1

        // Step 3: build the length-digit string from most-significant bit to least
        StringBuilder sb = new StringBuilder(length);
        // we need the binary representation of offset in exactly 'length' bits
        for (int i = length - 1; i >= 0; i--) {
            // extract i-th bit (MSB side)
            long bit = (offset >> i) & 1L; // 0 or 1
            sb.append(bit == 0 ? '3' : '4');
        }

        return sb.toString();
    }

    // simple main to test
    public static void main(String[] args) {
        long[] tests = {1,2,3,4,5,6,7,8,9,10,11,12};
        for (long t : tests) {
            System.out.println(t + " -> " + nthNumber(t));
        }
        // expected:
        // 1->3, 2->4, 3->33, 4->34, 5->43, 6->44, 7->333, ...
    }
}
