package test.com.wrox.algorithms.iteration;

import main.com.wrox.algorithms.iteration.classes.ArrayIterator;
import main.com.wrox.algorithms.iteration.exceptions.IteratiorOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayIteratorTest {
  @Test
  public void testIterationRespectsBounds() {
    Object[] array = new Object[] {"A", "B", "C", "D", "E", "F"};

    ArrayIterator iterator = new ArrayIterator(array, 1, 3);

    iterator.first();
    assertFalse(iterator.isDone());
    assertSame(array[1], iterator.current());

    iterator.next();
    assertFalse(iterator.isDone());
    assertSame(array[2], iterator.current());

    iterator.next();
    assertFalse(iterator.isDone());
    assertSame(array[3], iterator.current());

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
  public void testBackwardsIteration() {
    Object[] array = new Object[]{"A", "B", "C"};
    ArrayIterator iterator = new ArrayIterator(array);

    iterator.last();
    assertFalse(iterator.isDone());
    assertSame(array[2], iterator.current());

    iterator.previous();
    assertFalse(iterator.isDone());
    assertSame(array[1], iterator.current());

    iterator.previous();
    assertFalse(iterator.isDone());
    assertSame(array[0], iterator.current());

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
