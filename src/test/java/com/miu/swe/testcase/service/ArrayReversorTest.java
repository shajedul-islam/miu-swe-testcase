package com.miu.swe.testcase.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {

    private ArrayFlattenerService arrayFlattenerServiceMock;
    private ArrayReversor arrayReversor;

    @BeforeEach
    public void setUp() {
        arrayFlattenerServiceMock = Mockito.mock(ArrayFlattenerService.class);
        arrayReversor = new ArrayReversor(arrayFlattenerServiceMock);
    }

    @Test
    public void testReverseArrayForLegitimateInput() {
        int[][] input = {{1,3}, {0}, {4,5,9}};
        int[] flattened = {1,3,0,4,5,9};
        when(arrayFlattenerServiceMock.flattenArray(input)).thenReturn(flattened);

        int[] expected = {9,5,4,0,3,1};
        int[] result = arrayReversor.reverseArray(input);

        assertArrayEquals(expected, result);
        verify(arrayFlattenerServiceMock, times(1)).flattenArray(input);
    }

    @Test
    public void testReverseArrayForNullInput() {
        int[][] input = null;
        when(arrayFlattenerServiceMock.flattenArray(input)).thenReturn(null);

        int[] result = arrayReversor.reverseArray(input);
        assertNull(result);

        verify(arrayFlattenerServiceMock, times(1)).flattenArray(input);
    }
}