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

    public static void SortBubble(int[] arr, int start, int end) {
        long startTime = System.nanoTime();
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int j = start; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
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
            int current = arr[i];
            int j = i;
            while (j > start && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;
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
