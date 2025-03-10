public class SortLibrary {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void show(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int MinItem(int[] arr, int start, int end) {
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int MaxItem(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void SortBubble(int[] arr, int start, int end) {
        long startTime = System.nanoTime();
        for (int i = start; i < end; i++) {
            for (int j = start; j < end - (i - start); j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Час виконання (наносек): " + (endTime - startTime));
        System.out.println("Складність: O(n^2)");
    }

    public static void SortInsertion(int[] arr, int start, int end) {
        long startTime = System.nanoTime();
        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        System.out.println("Час виконання (наносек): " + (endTime - startTime));
        System.out.println("Складність: O(n^2)");
    }

    public static void SortSelection(int[] arr, int start, int end) {
        long startTime = System.nanoTime();
        for (int i = start; i < end; i++) {
            int minIndex = MinItem(arr, i, end);
            swap(arr, i, minIndex);
        }
        long endTime = System.nanoTime();
        System.out.println("Час виконання (наносек): " + (endTime - startTime));
        System.out.println("Складність: O(n^2)");
    }
}
