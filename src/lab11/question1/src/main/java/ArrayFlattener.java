import java.util.Arrays;

public class ArrayFlattener {
    int[] flattenArray(int[][] a) {
        if(a == null || a.length == 0) return null;

        int count = 0;
        for(int[] aa : a) {
            count += aa.length;
        }

        int[] result = new int[count];
        int i = 0;
        for(int[] aa : a) {
            for(int value : aa) {
                result[i++] = value;
            }
        }
        return result;
    }

//    int[] flattenArray(int[][] a) {
//        return Arrays.stream(a).
//                flatMapToInt(Arrays::stream)
//                .toArray();
//    }

    public static void main(String[] args) {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        System.out.printf("Using nested loop:\n%s\n", Arrays.toString(arrayFlattener.flattenArray(new int[][]{
                {1, 2, 3}, {0}, {4, 5, 9}
        })));
    }
}
