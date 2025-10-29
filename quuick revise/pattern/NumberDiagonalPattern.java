public class NumberDiagonalPattern {
    public static void main(String[] args) {
        int n = 15;  // you can change to 10 to test

        int start = 1;  // first row always starts with 1
        int row = 1;

        while (start <= n) {
            int num = start;
            int diff = row + 1;  // difference starts from row+1

            while (num <= n) {
                System.out.print(num + " ");
                num = num + diff;
                diff++;  // difference increases for next element
            }

            System.out.println();

            // prepare next row’s starting number
            start = start + row;
            row++;
        }
    }
}
