package collection;

import Iterator.Iterable;
import Iterator.Iterator;

public interface IList<T> extends Iterable<T> {
    void add (T T);
    T get (int position);
    void remove(int index);

    boolean contain (T T);
    int size();
    boolean isEmpty();

    Iterator<T> iterator();
}
