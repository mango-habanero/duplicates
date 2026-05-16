package com.mango.habanero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

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

        @ParameterizedTest(name = "Returns empty set for input: {0}")
        @MethodSource("emptyResultInputs")
        @DisplayName("Returns empty set when no duplicates exist")
        void givenNoDuplicatesWhenFindDuplicatesCalledThenReturnsEmptySet(int[] input) {
            assertTrue(finder.findDuplicates(input).isEmpty());
        }

        static Stream<int[]> emptyResultInputs() {
            return Stream.of(
                    new int[]{},
                    new int[]{1},
                    new int[]{1, 2, 3}
            );
        }

        @ParameterizedTest(name = "Returns {1} for input: {0}")
        @MethodSource("duplicateInputs")
        @DisplayName("Returns correct duplicates for input")
        void givenDuplicatesWhenFindDuplicatesCalledThenReturnsExpectedSet(int[] input, Set<Integer> expected) {
            assertEquals(expected, finder.findDuplicates(input));
        }

        static Stream<org.junit.jupiter.params.provider.Arguments> duplicateInputs() {
            return Stream.of(
                    of(new int[]{1, 2, 3, 2},          Set.of(2)),
                    of(new int[]{1, 2, 3, 4, 2, 5, 1}, Set.of(1, 2)),
                    of(new int[]{3, 1, 3, 1},           Set.of(1, 3)),
                    of(new int[]{1, 2, 1, 2},           Set.of(1, 2)),
                    of(new int[]{1, 1, 1},              Set.of(1))
            );
        }
    }
}