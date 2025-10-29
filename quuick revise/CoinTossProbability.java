public class CoinTossProbability {

    // Function to compute factorial manually
    static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Function to compute nCr = n! / (r! * (n - r)!)
    static long combination(int n, int r) {
        if (r > n) return 0;
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // Function to compute power manually (base^exp)
    static double power(double base, int exp) {
        double result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;  // number of coin tosses
        int R = 2;  // number of heads

        long nCr = combination(N, R);
        double totalOutcomes = power(2, N);
        double probability = nCr / totalOutcomes;

        System.out.println("Probability of getting exactly " + R + " heads when tossing " + N + " coins = " + probability);
    }
}
