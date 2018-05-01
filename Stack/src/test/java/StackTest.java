import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {

    @Test
    void whenInitializedThenCapacityIsSet() {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(5, stack.getCapacity());
    }

    @Test
    void givenEmptyStackWhenGettingQuantityOfFreeSpacesThenReturnCorrectValue() {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(5, stack.getFreeSpaceSize());
    }

    @Test
    void whenPushFiveTimesThenElementsAreProperlyPushed() {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        String expected = " 0 1 2 3 4";
        assertEquals(expected, stack.toString());
    }

    @Test
    void whenPushFiveTimesThenSizeIncreases() {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals(5, stack.getSize());
    }

    @Test
    void givenFullStackWhenPushThenStackOverflowException() {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertThrows(StackOverflow.class, () -> stack.push(8));
    }

    @Test
    void whenPopThenLastElementIsPopped() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(9);
        stack.push(10);
        stack.push(3);
        System.out.println(stack);
        Integer expected1 = 3;
        Integer expected2 = 10;
        assertEquals(expected1, stack.pop());
        assertEquals(expected2, stack.pop());
    }

    @Test
    void givenEmptyStackWhenPopThenThrowStackUnderflow() {
        Stack<Integer> stack = new Stack<>(3);
        assertThrows(StackUnderflow.class, stack::pop);
    }
}
