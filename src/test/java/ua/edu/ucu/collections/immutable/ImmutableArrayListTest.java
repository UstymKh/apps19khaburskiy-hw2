package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        expectedResult = new Object[]{};
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5};
        testImmutableArrayList = testImmutableArrayList.add(5);
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 2};
        testImmutableArrayList = testImmutableArrayList.add(2);
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 2, 110};
        testImmutableArrayList = testImmutableArrayList.add(110);
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 2, 3, 110};
        testImmutableArrayList = testImmutableArrayList.add(2, 3);
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testAddAll() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        expectedResult = new Object[]{};
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5};
        testImmutableArrayList = testImmutableArrayList.addAll(new Object[]{5});
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 5, 2};
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 2});
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);

        expectedResult = new Object[]{5, 11, 77, 5, 2};
        testImmutableArrayList = testImmutableArrayList.add(1, new Object[]{11, 77});
        realResult = testImmutableArrayList.toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testGet() {
        Object expectedResult;
        Object realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = 3;
        realResult = testImmutableArrayList.get(1);
        assertEquals(expectedResult, realResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexError() {
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList.add(3, 1);
    }
}
