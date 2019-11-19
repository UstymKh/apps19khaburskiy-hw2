package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testSet() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[]{5, 4};
        realResult = testImmutableArrayList.set(1, 4).toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testSize() {
        Object expectedResult;
        Object realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = 2;
        realResult = testImmutableArrayList.size();
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void testRemove() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[]{5};
        realResult = testImmutableArrayList.remove(1).toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testClear() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[0];
        realResult = testImmutableArrayList.clear().toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test
    public void testIsEmpty() {
        boolean expectedResult;
        boolean realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = true;
        realResult = testImmutableArrayList.isEmpty();
        assertNotEquals(expectedResult, realResult);
    }

    @Test
    public void testIndexOf() {
        Object expectedResult;
        Object realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = 0;
        realResult = testImmutableArrayList.indexOf(5);
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void testToArray() {
        Object[] expectedResult;
        Object[] realResult;
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(new Object[]{5, 3});
        expectedResult = new Object[]{5};
        realResult = testImmutableArrayList.remove(1).toArray();
        assertArrayEquals(expectedResult, realResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexError() {
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList.add(3, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexError() {
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexError() {
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList = testImmutableArrayList.add(7);
        testImmutableArrayList.set(3, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexError() {
        ImmutableLinkedList testImmutableArrayList = new ImmutableLinkedList();
        testImmutableArrayList.addAll(3, new Object[]{4, 5});
    }
}
