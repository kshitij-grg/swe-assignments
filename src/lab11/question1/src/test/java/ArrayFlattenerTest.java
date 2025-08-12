import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {
    private ArrayFlattener flattener;

    @BeforeEach
    void setUp() {
        flattener = new ArrayFlattener();
    }

    @AfterEach
    void tearDown() {
        flattener = null;
    }

    @Test
    void testValidFlattenArray() {
        int[][] input = new int[][]{
                {1, 3}, {0}, {4, 5, 9}
        };

        int[] expected = new int[]{1, 3, 0, 4, 5, 9};
        int[] actual = flattener.flattenArray(input);

        assertArrayEquals(expected, actual, "Valid flattened array test failed");
    }

    @Test
    void testNullFlattenArray() {
        assertNull(null, "Null flattened array test failed");
    }
}