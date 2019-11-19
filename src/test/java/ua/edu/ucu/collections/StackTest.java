package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    private Stack testStack = new Stack();

    @Test
    public void test() {
        testStack.push(3);
        testStack.push(4);
        Object expectedResult = 3;
        Object realResult = testStack.peek();
        assertEquals(expectedResult, realResult);
        expectedResult = 3;
        testStack.pop();
        realResult = testStack.pop();
        assertEquals(expectedResult, realResult);
    }

}
