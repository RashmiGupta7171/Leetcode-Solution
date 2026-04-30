// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        // Initialize nextElement
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        }
    }

    // Returns the next element without moving the pointer
    public Integer peek() {
        return nextElement;
    }

    // Returns the next element and moves pointer forward
    @Override
    public Integer next() {
        Integer result = nextElement;
        
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
        
        return result;
    }

    // Returns true if there are more elements
    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}