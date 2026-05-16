package com.mango.habanero;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 2, 5, 1};
        Set<Integer> duplicates = new DuplicateFinder().findDuplicates(input);
        logger.log(Level.INFO, () -> duplicates.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}