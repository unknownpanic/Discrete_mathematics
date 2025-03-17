public class Comb {

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int factorial(int n) {
        if (n == 0){
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

    public static boolean GenPerm(int[] A) {
        int n = A.length;
        int i = n - 2;

        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = n - 1;
        while (A[j] <= A[i]) {
            j--;
        }

        swap(A, i, j);

        SortBubble(A, i + 1, n - 1, 1);

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
}