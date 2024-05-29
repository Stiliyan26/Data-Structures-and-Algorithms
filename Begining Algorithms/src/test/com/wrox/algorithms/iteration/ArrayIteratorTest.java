package test.com.wrox.algorithms.iteration;

import main.com.wrox.algorithms.iteration.ArrayIterator;
import main.com.wrox.algorithms.iteration.exceptions.IteratiorOutOfBoundsException;
import org.junit.Assert;
import org.junit.Test;

public class ArrayIteratorTest {
  @Test
  public void testBackwardsIteration() {
    Object[] array = new Object[]{"A", "B", "C"};
    ArrayIterator iterator = new ArrayIterator(array);

    iterator.last();
    Assert.assertFalse(iterator.isDone());
    Assert.assertSame(array[2], iterator.current());

    iterator.previous();
    Assert.assertFalse(iterator.isDone());
    Assert.assertSame(array[1], iterator.current());

    iterator.previous();
    Assert.assertFalse(iterator.isDone());
    Assert.assertSame(array[0], iterator.current());

    iterator.previous();
    Assert.assertTrue(iterator.isDone());
    try {
      iterator.current();
      Assert.fail();
    } catch (IteratiorOutOfBoundsException e) {
    }
  }
}
