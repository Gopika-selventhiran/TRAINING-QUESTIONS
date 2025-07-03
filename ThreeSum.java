import java.util.Scanner;

public class ThreeSum {

    public static String checkThreeSum(int[] arr) {
        int target = arr[arr.length - 1]; // Last number (7th element)
        boolean result = findCombination(arr, arr.length - 1, 0, 0, 0);
        return result ? "Yes" : "No";
    }

    // Recursive method to check all combinations of 3 numbers
    public static boolean findCombination(int[] arr, int n, int start, int count, int sum) {
        if (count == 3) {
            return sum == arr[n]; // Compare with last element
        }
        if (start >= n) {
            return false;
        }

        // Include current number
        if (findCombination(arr, n, start + 1, count + 1, sum + arr[start])) {
            return true;
        }

        // Exclude current number
        if (findCombination(arr, n, start + 1, count, sum)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fixed size = 7
        int size = 7;
        int[] arr = new int[size];

        System.out.println("Enter 7 numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        String result = checkThreeSum(arr);
        System.out.println(result);
    }
}
