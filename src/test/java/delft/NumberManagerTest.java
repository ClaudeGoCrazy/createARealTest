package delft;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberManagerTest {

    @Test
    void testAddNumberAndGetNumbers() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(10);
        numberManager.addNumber(20);

        List<Integer> numbers = numberManager.getNumbers();
        assertEquals(List.of(10, 20), numbers, "The numbers should match the added values.");
    }

    @Test
    void testGetSumWithMultipleNumbers() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(5);
        numberManager.addNumber(15);
        numberManager.addNumber(20);

        int sum = numberManager.getSum();
        assertEquals(40, sum, "The sum of 5, 15, and 20 should be 40.");
    }

    @Test
    void testGetSumWithNoNumbers() {
        NumberManager numberManager = new NumberManager();

        int sum = numberManager.getSum();
        assertEquals(0, sum, "The sum of an empty list should be 0.");
    }

    @Test
    void testGetMaxWithMultipleNumbers() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(3);
        numberManager.addNumber(7);
        numberManager.addNumber(1);

        int max = numberManager.getMax();
        assertEquals(7, max, "The maximum number in the list should be 7.");
    }

    @Test
    void testGetMaxWithNegativeNumbers() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(-10);
        numberManager.addNumber(-3);
        numberManager.addNumber(-7);

        int max = numberManager.getMax();
        assertEquals(-3, max, "The maximum number in the list should be -3.");
    }

    @Test
    void testGetMaxWithSingleNumber() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(42);

        int max = numberManager.getMax();
        assertEquals(42, max, "The maximum number in the list should be the single number 42.");
    }

    @Test
    void testGetMaxThrowsExceptionWhenNoNumbers() {
        NumberManager numberManager = new NumberManager();

        Exception exception = assertThrows(IllegalStateException.class, numberManager::getMax);
        assertEquals("No numbers in the list", exception.getMessage(), "An exception should be thrown when calling getMax on an empty list.");
    }

    @Test
    void testClear() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(5);
        numberManager.addNumber(10);

        numberManager.clear();

        List<Integer> numbers = numberManager.getNumbers();
        assertTrue(numbers.isEmpty(), "The list should be empty after calling clear.");
        assertEquals(0, numberManager.getSum(), "The sum should be 0 after calling clear.");
    }

    @Test
    void testGetNumbersReturnsNewList() {
        NumberManager numberManager = new NumberManager();
        numberManager.addNumber(5);
        numberManager.addNumber(10);

        List<Integer> numbers = numberManager.getNumbers();
        numbers.add(20); // Attempt to modify the returned list

        List<Integer> actualNumbers = numberManager.getNumbers();
        assertEquals(List.of(5, 10), actualNumbers, "The internal list should not be affected by modifications to the returned list.");
    }
}
