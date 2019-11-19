package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableLinkedList testImmutableLinkedList = new ImmutableLinkedList();
        expectedResult = new Object[]{};
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5};
        testImmutableLinkedList = testImmutableLinkedList.add(5);
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 2};
        testImmutableLinkedList = testImmutableLinkedList.add(2);
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 2, 110};
        testImmutableLinkedList = testImmutableLinkedList.add(110);
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 2, 3, 110};
        testImmutableLinkedList = testImmutableLinkedList.add(2, 3);
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testAddAll() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableLinkedList testImmutableLinkedList = new ImmutableLinkedList();
        expectedResult = new Object[]{};
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5};
        testImmutableLinkedList = testImmutableLinkedList.addAll(new Object[]{5});
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 5, 2};
        testImmutableLinkedList = testImmutableLinkedList.add(new Object[]{5, 2});
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 11, 77, 5, 2};
        testImmutableLinkedList = testImmutableLinkedList.add(1, new Object[]{11, 77});
        realResult = testImmutableLinkedList.toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testGet() {
        Object expectedResult;
        Object realResult;
        ImmutableLinkedList testImmutableLinkedList = new ImmutableLinkedList();
        testImmutableLinkedList = testImmutableLinkedList.add(new Object[]{5, 3});
        expectedResult = 3;
        realResult = testImmutableLinkedList.get(1);
        assertEquals(expectedResult, realResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testaddIndexError() {
        ImmutableLinkedList testImmutableLinkedList = new ImmutableLinkedList();
        testImmutableLinkedList.add(3, 1);
    }
}
