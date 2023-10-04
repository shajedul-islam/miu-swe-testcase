package com.miu.swe.testcase.service;

import org.springframework.stereotype.Service;

@Service
public interface ArrayFlattenerService {
    int[] flattenArray(int[][] nestedArray);
}