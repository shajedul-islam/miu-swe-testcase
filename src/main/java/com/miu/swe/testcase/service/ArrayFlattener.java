package com.miu.swe.testcase.service;
import org.springframework.stereotype.Service;

@Service
public class ArrayFlattener {

    public int[] flattenArray(int[][] nestedArray) {
        if(nestedArray == null) {
            return null;
        }

        int totalLength = 0;
        for(int[] innerArray : nestedArray) {
            totalLength += innerArray.length;
        }

        int[] flattenedArray = new int[totalLength];

        int currentIndex = 0;
        for(int[] innerArray : nestedArray) {
            for(int value : innerArray) {
                flattenedArray[currentIndex++] = value;
            }
        }

        return flattenedArray;
    }
}