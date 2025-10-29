public class AlternateSortZoho {

    // Manual selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Alternate sorting logic
    public static int[] alternateSort(int[] arr) {
        int n = arr.length;
        // Step 1: sort the array (manually)
        selectionSort(arr);

        // Step 2: use two pointers to pick max and min alternately
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = 0;

        while (left <= right) {
            if (index < n) result[index++] = arr[right--]; // max
            if (index < n) result[index++] = arr[left++];  // min
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 2, 5, 3, 6};
        int[] result = alternateSort(arr);

        System.out.print("Alternate Sorted Array: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
