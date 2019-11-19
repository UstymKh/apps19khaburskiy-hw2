package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testSet() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[]{5, 4};
        realResult = testImmutableArrayList.set(1, 4).toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testSize() {
        Object expectedResult;
        Object realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = 2;
        realResult = testImmutableArrayList.size();
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void testRemove() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[]{5};
        realResult = testImmutableArrayList.remove(1).toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testClear() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[0];
        realResult = testImmutableArrayList.clear().toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testIsEmpty() {
        boolean expectedResult;
        boolean realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = true;
        realResult = testImmutableArrayList.isEmpty();
        assertNotEquals(expectedResult, realResult);
    }

    @Test
    public void testIndexOf() {
        Object expectedResult;
        Object realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = 0;
        realResult = testImmutableArrayList.indexOf(5);
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void testToArray() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[]{5};
        realResult = testImmutableArrayList.remove(1).toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexError() {
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList.add(3, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexError() {
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexError() {
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList = testImmutableArrayList.add(7);
        testImmutableArrayList.set(3, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexError() {
        ImmutableArrayList testImmutableArrayList = new ImmutableArrayList();
        testImmutableArrayList.addAll(3, new Object[]{4, 5});
    }
}
