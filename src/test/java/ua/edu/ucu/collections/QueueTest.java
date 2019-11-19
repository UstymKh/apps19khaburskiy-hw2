package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    private Queue testQueue = new Queue();

    @Test
    public void test() {
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        Object expectedResult = 3;
        Object realResult = testQueue.peek();
        assertEquals(expectedResult, realResult);
        expectedResult = 4;
        testQueue.dequeue();
        realResult = testQueue.dequeue();
        assertEquals(expectedResult, realResult);
    }

}
