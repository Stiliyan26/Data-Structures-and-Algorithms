package main.com.wrox.algorithms.iteration.classes;

import main.com.wrox.algorithms.iteration.interfaces.Iterator;
import main.com.wrox.algorithms.iteration.interfaces.Predicate;
import static org.junit.Assert.*;
public class DummyPredicate implements Predicate {
    private final Iterator _iterator;
    private final boolean _result;

    public DummyPredicate(boolean _result, Iterator _iterator) {
        this._iterator = _iterator;
        this._result = _result;
        _iterator.first();
    }

    @Override
    public boolean evaluate(Object object) {
        if (_iterator.current() != object) {
            return !_result;
        }

        _iterator.next();
        return _result;
    }
}
