import service.ArrayFlattenerService;

public class ArrayReverser {
    private final ArrayFlattenerService flattenerService;

    public ArrayReverser(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }

    public int[] reverseArray(int[][] input) {
        if (input == null) {
            return null;
        }
        int[] flattened = flattenerService.flattenArray(input);
        if (flattened == null) {
            return null;
        }

        int n = flattened.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = flattened[n - 1 - i];
        }
        return reversed;
    }
}
