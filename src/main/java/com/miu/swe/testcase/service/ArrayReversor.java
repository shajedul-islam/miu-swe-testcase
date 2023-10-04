package com.miu.swe.testcase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrayReversor {

    private final ArrayFlattenerService arrayFlattenerService;

    @Autowired
    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] nestedArray) {
        int[] flattenedArray = arrayFlattenerService.flattenArray(nestedArray);

        if (flattenedArray == null) {
            return null;
        }

        int[] reversedArray = new int[flattenedArray.length];
        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }

        return reversedArray;
    }
}