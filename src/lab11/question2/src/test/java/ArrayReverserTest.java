import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import service.ArrayFlattenerService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayReverserTest {
    @Mock
    private ArrayFlattenerService flattenerService;
    private AutoCloseable mocks;
    private ArrayReverser arrayReverser;

    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
        arrayReverser = new ArrayReverser(flattenerService);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (mocks != null) {
            mocks.close();
        }
        arrayReverser = null;
    }

    @Test
    public void testReverseArrayWithValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattened = {1, 3, 0, 4, 5, 9};
        int[] expectedReversed = {9, 5, 4, 0, 3, 1};

        when(flattenerService.flattenArray(input)).thenReturn(flattened);

        int[] actualReversed = arrayReverser.reverseArray(input);

        verify(flattenerService, times(1)).flattenArray(input);

        assertArrayEquals(expectedReversed, actualReversed);
    }

    @Test
    public void testReverseArrayWithNullInput() {
        when(flattenerService.flattenArray(null)).thenReturn(null);

        int[] actual = arrayReverser.reverseArray(null);

        verify(flattenerService, never()).flattenArray(ArgumentMatchers.any());

        assertNull(actual);
    }
}