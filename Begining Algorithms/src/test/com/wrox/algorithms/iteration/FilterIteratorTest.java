package test.com.wrox.algorithms.iteration;

import main.com.wrox.algorithms.iteration.classes.ArrayIterator;
import main.com.wrox.algorithms.iteration.classes.DummyPredicate;
import main.com.wrox.algorithms.iteration.classes.FilterIterator;
import main.com.wrox.algorithms.iteration.exceptions.IteratiorOutOfBoundsException;
import main.com.wrox.algorithms.iteration.interfaces.Iterator;
import org.junit.Test;

import static org.junit.Assert.*;
public class FilterIteratorTest {
    private static final Object[] ARRAY = new Object[]{"A", "B", "C"};

    @Test
    public void testForwardsIterationIncludesItemsWhenPredicateReturnsTrue() {
        Iterator expectediterator = new ArrayIterator(ARRAY);
        Iterator underlyingIterator = new ArrayIterator(ARRAY);

        Iterator iterator = new FilterIterator(underlyingIterator,
                new DummyPredicate(true, expectediterator));

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());

        try {
            iterator.current();
            fail();
        } catch(IteratiorOutOfBoundsException e) {
            //expected
        }

        assertTrue(expectediterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }
}
