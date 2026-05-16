package com.mango.habanero;

import java.util.HashSet;
import java.util.Set;

public class DuplicateFinder {

    public Set<Integer> findDuplicates(int[] input) {
        if (input == null) throw new IllegalArgumentException("Input must not be null");

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int value : input) {
            if (!seen.add(value)) duplicates.add(value);
        }

        return duplicates;
    }
}