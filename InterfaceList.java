public interface InterfaceList <T> {
    void add (T T);
    T get (int position);
    void remove(int index);

    boolean contain (T T);
    int size();
    boolean isEmpty();
}
