package main.com.wrox.algorithms.iteration;

import main.com.wrox.algorithms.iteration.exceptions.IteratiorOutOfBoundsException;

public class ReverseIterator implements Iterator {
    private final Iterator _iterator;

    public ReverseIterator(Iterator iterator) {
        assert iterator != null : "iterator can't be null";
        this._iterator = iterator;
    }

    @Override
    public void first() {
        _iterator.last();
    }

    @Override
    public void last() {
        _iterator.first();
    }

    @Override
    public boolean isDone() {
        return _iterator.isDone();
    }

    @Override
    public void next() {
        _iterator.previous();
    }

    @Override
    public void previous() {
        _iterator.next();
    }

    @Override
    public Object current() throws IteratiorOutOfBoundsException {
        return _iterator.current();
    }
}
