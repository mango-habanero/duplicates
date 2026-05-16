package com.mango.habanero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DuplicateFinder")
class DuplicateFinderTest {

    private DuplicateFinder finder;

    @BeforeEach
    void setUp() {
        finder = new DuplicateFinder();
    }

    @Nested
    @DisplayName("findDuplicates")
    class FindDuplicates {

        @Test
        @DisplayName("Throws IllegalArgumentException when input is null")
        void givenNullInputWhenFindDuplicatesCalledThenThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> finder.findDuplicates(null));
        }

        @Test
        @DisplayName("Returns empty set when input is empty")
        void givenEmptyArrayWhenFindDuplicatesCalledThenReturnsEmptySet() {
            assertTrue(finder.findDuplicates(new int[]{}).isEmpty());
        }

        @Test
        @DisplayName("Returns empty set when input contains a single element")
        void givenSingleElementWhenFindDuplicatesCalledThenReturnsEmptySet() {
            assertTrue(finder.findDuplicates(new int[]{1}).isEmpty());
        }

        @Test
        @DisplayName("Returns empty set when no duplicates exist")
        void givenAllUniqueElementsWhenFindDuplicatesCalledThenReturnsEmptySet() {
            assertTrue(finder.findDuplicates(new int[]{1, 2, 3}).isEmpty());
        }

        @Test
        @DisplayName("Returns single duplicate when one value appears more than once")
        void givenSingleDuplicateWhenFindDuplicatesCalledThenReturnsThatValue() {
            assertEquals(Set.of(2), finder.findDuplicates(new int[]{1, 2, 3, 2}));
        }

        @Test
        @DisplayName("Returns all duplicates when multiple values appear more than once")
        void givenMultipleDuplicatesWhenFindDuplicatesCalledThenReturnsAllDuplicates() {
            assertEquals(Set.of(1, 2), finder.findDuplicates(new int[]{1, 2, 3, 4, 2, 5, 1}));
        }

        @Test
        @DisplayName("Returns duplicates in order of first occurrence")
        void givenOutOfOrderDuplicatesWhenFindDuplicatesCalledThenPreservesInsertionOrder() {
            assertIterableEquals(List.of(3, 1), finder.findDuplicates(new int[]{3, 1, 3, 1}));
        }

        @Test
        @DisplayName("Returns all values when every element is duplicated")
        void givenAllElementsDuplicatedWhenFindDuplicatesCalledThenReturnsAllValues() {
            assertEquals(Set.of(1, 2), finder.findDuplicates(new int[]{1, 2, 1, 2}));
        }
    }
}