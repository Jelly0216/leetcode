// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.Iterator;
import java.util.NoSuchElementException;
class PeekingIterator284 implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peekValue;
    public PeekingIterator284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.peekValue = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekValue == null){
            if (!iterator.hasNext()) {
                throw new NoSuchElementException("111");
            }
            peekValue = iterator.next();
        }
        return peekValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peekValue == null) {
            if (!iterator.hasNext()) {
                throw new NoSuchElementException();
            }
            else {
                return iterator.next();
            }
        }
        Integer res = peekValue;
        peekValue = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return peekValue != null || iterator.hasNext();
    }
}