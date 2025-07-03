import java.util.Scanner;

public class ThreeSum {

    // Main function
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[7]; // Only 7 numbers
        System.out.println("Enter 7 numbers:");

        for (int i = 0; i < 7; i++) {
            arr[i] = scan.nextInt();
        }

        // Check and print result
        if (isSumFound(arr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // Function to check if any 3 numbers add up to last number
    public static boolean isSumFound(int[] arr) {
        int last = arr[6]; // last number
        return check(arr, 0, 0, 0, last); // Start checking
    }

    // Function to try all combinations of 3 numbers
    public static boolean check(int[] arr, int pos, int count, int total, int target) {
        // Base condition: if 3 numbers picked
        if (count == 3) {
            return total == target;
        }

        // Stop if gone through all first 6 numbers
        if (pos >= 6) {
            return false;
        }

        // Try including current number
        boolean include = check(arr, pos + 1, count + 1, total + arr[pos], target);

        // Try skipping current number
        boolean skip = check(arr, pos + 1, count, total, target);

        // Return true if either way works
        return include || skip;
    }
}
