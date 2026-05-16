package com.mango.habanero;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateFinder {

    public Set<Integer> findDuplicates(int[] input) {
        if (input == null) throw new IllegalArgumentException("Input must not be null");

        Set<Integer> seen = new LinkedHashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        for (int value : input) {
            if (!seen.add(value)) duplicates.add(value);
        }

        return duplicates;
    }
}