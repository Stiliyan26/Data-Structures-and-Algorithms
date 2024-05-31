package main.com.wrox.algorithms.iteration.interfaces;

import main.com.wrox.algorithms.iteration.exceptions.IteratiorOutOfBoundsException;

public interface Iterator {
  public void first();

  public void last();

  public boolean isDone();

  public void next();

  public void previous();

  public Object current() throws IteratiorOutOfBoundsException;
}
