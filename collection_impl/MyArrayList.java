package collection_impl;

import collection.IList;
import Iterator.Iterable;
import Iterator.Iterator;

public class MyArrayList<T> implements IList<T>, Iterable<T> {
    private Object[] objects;
    private int size = 0;

    public MyArrayList() {
        objects = new Object[1];
    }

    @Override
    public void add(T T) {
        if (size < objects.length) {
            objects[size++] = T;
        } else {
            resize();
            objects[size++] = T;
        }
    }

    @Override
    public T get(int position) {
        return (T) objects[position];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contain(T T) {
        boolean contain = false;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == T) {
                contain = true;
                break;
            } else contain = false;
        }
        return contain;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else
            return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        size = size() - 1;
        Object[] temp = new Object[size];
        if (index != 0) {
            for (int i = 0, j = 0; i < size(); i++, j++) {
                if (i != index - 1) {
                    temp[i] = objects[j];
                } else {
                    temp[i] = objects[j++];
                }
            }
        } else {
            for (int i = 0, j = 1; i < size; i++, j++) {
                temp[i] = objects[j];
            }
        }
        objects = temp;
    }


    void resize() {
        Object[] temp = new Object[objects.length + 1];

        for (int i = 0; i < objects.length; i++) {
            temp[i] = objects[i];
        }
        objects = temp;
    }

    private class Itr implements Iterator{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size && objects[currentIndex] != null;
        }

        @Override
        public Object next() {
            return objects[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
