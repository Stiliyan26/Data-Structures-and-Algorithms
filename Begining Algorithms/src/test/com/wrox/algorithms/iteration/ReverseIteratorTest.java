package test.com.wrox.algorithms.iteration;

import main.com.wrox.algorithms.iteration.ArrayIterator;
import main.com.wrox.algorithms.iteration.ReverseIterator;
import main.com.wrox.algorithms.iteration.exceptions.IteratiorOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIteratorTest {
    private static final Object[] ARRAY = new Object[]{"A", "B", "C"};

    @Test
    public void testForwardsIterationBecomesBackwards() {
        ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));

        iterator.first();
        assertFalse(iterator.isDone());
        assertEquals(ARRAY[2], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertEquals(ARRAY[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertEquals(ARRAY[0], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());

        try {
            iterator.current();
            fail();
        } catch (IteratiorOutOfBoundsException e) {
            //expected
        }
    }

    @Test
    public void testBackwardsIterationBecomesForwards() {
        ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));

        iterator.last();
        assertFalse(iterator.isDone());
        assertEquals(ARRAY[0], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertEquals(ARRAY[1], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertEquals(ARRAY[2], iterator.current());

        iterator.previous();
        assertTrue(iterator.isDone());

        try {
            iterator.current();
            fail();
        } catch (IteratiorOutOfBoundsException e) {
            //expected
        }
    }
}
