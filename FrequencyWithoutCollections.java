// Zoho Corporation
public class FrequencyWithoutCollections {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 3, 3, 4, 5};
        int n = arr.length;

        // Boolean array to mark visited elements
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;  // Skip already counted elements

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + " -> " + count);
        }
    }
}
