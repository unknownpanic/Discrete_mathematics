public class SortLibrary {
    public static int counterBubble;
    public static int counterInsertion;
    public static int counterSelection;


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

    public static void SortBubble(int[] arr, int start, int end, int order) {
        long startTime = System.nanoTime();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int j = start; j < end; j++) {
                if ((order == 2 && arr[j] > arr[j + 1]) || (order == 1 && arr[j] < arr[j + 1])) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                    counterBubble++;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Час виконання (наносек): " + (endTime - startTime));
        System.out.println("Складність: O(n^2):" + counterBubble);
    }


    public static void SortInsertion(int[] arr, int start, int end, int order) {
        long startTime = System.nanoTime();
        for (int i = start + 1; i <= end; i++) {
            int current = arr[i];
            int j = i;
            while (j > start && ((order == 2 && arr[j - 1] > current) || (order == 1 && arr[j - 1] < current))) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;
            counterInsertion++;
        }
        long endTime = System.nanoTime();
        System.out.println("Час виконання (наносек): " + (endTime - startTime));
        System.out.println("Складність: O(n^2): " + counterInsertion);
    }

    public static void SortSelection(int[] arr, int start, int end, int order) {
        long startTime = System.nanoTime();
        for (int i = start; i < end; i++) {
            int targetIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if ((order == 2 && arr[j] < arr[targetIndex]) || (order == 1 && arr[j] > arr[targetIndex])) {
                    targetIndex = j;
                }
            }
            swap(arr, i, targetIndex);
            counterSelection++;
        }
        long endTime = System.nanoTime();
        System.out.println("Час виконання (наносек): " + (endTime - startTime));
        System.out.println("Складність: O(n^2): " + counterSelection);
    }

}
