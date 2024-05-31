import main.com.wrox.algorithms.iteration.classes.ArrayIterator;
import main.com.wrox.algorithms.iteration.classes.DummyPredicate;
import main.com.wrox.algorithms.iteration.classes.FilterIterator;
import main.com.wrox.algorithms.iteration.interfaces.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        Object[] ARRAY = new Object[]{"A", "B", "C"};
        Object[] ARRAY2 = new Object[]{"d", "g", "h"};

        Iterator expectediterator = new ArrayIterator(ARRAY);
        Iterator underlyingIterator = new ArrayIterator(ARRAY2);

        Iterator iterator = new FilterIterator(underlyingIterator,
                new DummyPredicate(true, expectediterator));

        iterator.first();

        System.out.println(iterator.current());
    }
}
