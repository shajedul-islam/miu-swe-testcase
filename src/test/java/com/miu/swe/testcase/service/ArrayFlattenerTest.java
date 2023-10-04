package com.miu.swe.testcase.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener;

    @BeforeEach
    public void setUp() {
        arrayFlattener = new ArrayFlattener();
    }

    @Test
    public void testFlattenArrayForLegitimateInput() {
        int[][] input = {{1,3}, {0}, {4, 5, 9}};
        int[] expected = {1,3,0,4,5,9};
        int[] result = arrayFlattener.flattenArray(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlattenArrayForNullInput() {
        int[][] input = null;
        int[] result = arrayFlattener.flattenArray(input);
        assertNull(result);
    }
}