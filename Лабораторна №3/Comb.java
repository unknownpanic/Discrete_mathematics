import java.util.Arrays;

public class Comb {
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int A(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    public static int A_repeated(int n, int k) {
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= n;
        }
        return result;
    }

    public static int C(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int C_repeated(int n, int k) {
        return C(n + k - 1, k);
    }

    public static void SortBubble(int[] arr, int start, int end, int order) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int j = start; j < end; j++) {
                if ((order == 1 && arr[j] > arr[j + 1]) || (order == 2 && arr[j] < arr[j + 1])) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }

    public static boolean GenPerm(int[] A, int k) {
        int n = A.length;
        int i = k - 1;

        while (i >= 0 && isMaximal(A, i, k)) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = findMinGreater(A, i);
        swap(A, i, j);
        Arrays.sort(A, i + 1, n);

        return true;
    }

    public static boolean GenComb(int[] A, int n, int k) {
        int i = k - 1;

        while (i >= 0 && A[i] == n - k + i + 1) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        A[i]++;

        for (int j = i + 1; j < k; j++) {
            A[j] = A[j - 1] + 1;
        }

        return true;
    }

    private static boolean isMaximal(int[] A, int i, int k) {
        if (i == k - 1) {
            int maxRight = A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > maxRight) {
                    maxRight = A[j];
                }
            }
            return A[i] >= maxRight;
        }
        return A[i] >= A[i + 1];
    }

    private static int findMinGreater(int[] A, int i) {
        int minGreater = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int j = i + 1; j < A.length; j++) {
            if (A[j] > A[i] && A[j] < minGreater) {
                minGreater = A[j];
                minIndex = j;
            }
        }
        return minIndex;
    }


}