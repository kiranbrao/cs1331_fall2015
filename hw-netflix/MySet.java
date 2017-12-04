import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

/**
* This class implements the SimpleSet interface
*
* @param <T> Generic type T
* @version 1.0
* @author Kiran Rao
*/
public class MySet<T> implements Set<T> {

    private T[] backingArray;
    private int numElements;

    /**
     * Constructs a MySet object using instance variables
     * A backing array of size 0 is created
     * The initial number of elements is 0
     */
    @SuppressWarnings("unchecked")
    public MySet() {
        numElements = 0;
        backingArray = (T[]) new Object[numElements];
    }

    /**
     * Adds a new object of generic type T to MySet
     * if the object already exists in MySet, it will not be added again
     * @param t  The new object of generic type T being added to MySet
     * @return a boolean representing if the objects was added
     */
    @SuppressWarnings("unchecked")
    public boolean add(T t) {
        boolean inSet = false;
        for (T setT : backingArray) {
            if (setT.equals(t)) {
                inSet = true;
            }
        }
        if (!inSet) {
            ++numElements;
            T[] backingArrayTemp = (T[]) new Object[numElements];
            for (int i = 0; i < (backingArray.length); i++) {
                backingArrayTemp[i] = backingArray[i];
            }
            backingArrayTemp[numElements - 1] = t;
            backingArray = backingArrayTemp;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a collection of new objects of generic type T to MySet
     * if an object already exists in MySet, it will not be added again
     * @param c  The collection of new objects of generic type T
        being added to MySet
     * @return a boolean representing if MySet was changed
     */
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends T> c) {
        boolean[] additions = new boolean[c.size()];
        int index = 0;
        for (T setT : c) {
            additions[index] = add(setT);
            ++index;
        }
        for (boolean b : additions) {
            if (b) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes all objects of MySet
     * MySet becomes an empty Set
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        T[] backingArrayTemp = (T[]) new Object[0];
        backingArray = backingArrayTemp;

    }

    /**
     * Checks if an object exists within MySet
     * @param o  The object being tested for existence within MySet
     * @return a boolean representing if the object exists within MySet
     */
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        T oCasted = (T) o;
        for (T setT : backingArray) {
            if (setT.equals(oCasted)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a Collection of objects exists within MySet
     * @param c  The Collection of objects being tested for
        existence within MySet
     * @return a boolean representing if all of the object exist within MySet
     */
    @SuppressWarnings("unchecked")
    public boolean containsAll(Collection<?> c) {
        boolean[] additions = new boolean[c.size()];
        int index = 0;
        for (Object setT : c) {
            additions[index] = contains(setT);
            ++index;
        }
        for (boolean b : additions) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * Overrides the equals method to compare the current
        MySet to another object
     * @param o  The other object being compared to the current object,
        casted as a Set
     * @return a boolean representing if the objects are equal
        according to the new equals() method
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o instanceof Set<?>) {
            Set oMySet = (Set) o;
            if (oMySet.size() == backingArray.length) {
                if (containsAll(oMySet)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Overrides the hashCode method to be be consistent
        with overridden equals() method
     * @return an int value for a hashCode overwrite
     */
    public int hashCode() {
        int result = 17;
        result = 31 * result + backingArray.hashCode();
        return result;
    }

    /**
     * Checks if MySet is empty
     * @return a boolean representing whether or not MySet is empty
     */
    public boolean isEmpty() {
        if (backingArray.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * Removes an object from MySet
     * if the object does not exist in MySet, nothing will be removed
     * @param o  The object being removed from MySet
     * @return a boolean representing if the object was removed
     */
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        boolean inSet = false;
        int counter = 0;
        int foundIndex = 0;
        for (T setT : backingArray) {
            if (setT.equals(o)) {
                inSet = true;
                foundIndex = counter;
            }
            ++counter;
        }
        if (inSet) {
            --numElements;
            T[] backingArrayTemp = (T[]) new Object[numElements];
            if ((foundIndex + 1) == backingArray.length) {
                for (int i = 0; i < (backingArray.length - 1); i++) {
                    backingArrayTemp[i] = backingArray[i];
                }
                backingArray = backingArrayTemp;
                return true;
            } else {
                backingArray[foundIndex] = null;
                for (int i = 0, j = 0; j < (backingArray.length); i++, j++) {
                    if (backingArray[i] == null) {
                        ++j;
                    }
                    backingArrayTemp[i] = backingArray[j];
                }
                backingArray = backingArrayTemp;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a Collection of objects from MySet
     * if the objects do not exist in MySet, nothing will be removed
     * @param c  The Collection of objects being removed from MySet
     * @return a boolean representing if MySet was changed
     */
    public boolean removeAll(Collection<?> c) {
        boolean[] removals = new boolean[c.size()];
        int index = 0;
        for (Object setT : c) {
            removals[index] = remove(setT);
            ++index;
        }
        for (boolean b : removals) {
            if (b) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reduces MySet to a Collection of objects
     * if the objects do not exist in MySet, they will not be retained in MySet
     * @param c  The Collection of objects to be kept in MySet
     * @return a boolean representing if MySet was changed
     */
    @SuppressWarnings("unchecked")
    public boolean retainAll(Collection<?> c) {
        int numFound = 0;
        boolean[] found = new boolean[c.size()];
        int booleanIndex = 0;
        for (Object setT : c) {
            if (contains(setT)) {
                ++numFound;
                found[booleanIndex] = true;
            } else {
                found[booleanIndex] = false;
            }
            ++booleanIndex;
        }
        boolean overall = false;
        for (boolean b : found) {
            if (b) {
                overall = true;
            }
        }
        if (overall) {
            numElements = numFound;
            T[] backingArrayTemp = (T[]) new Object[numElements];
            int index = 0;
            for (Object setT : c) {
                if (contains(setT)) {
                    backingArrayTemp[index] = (T) setT;
                    index++;
                }
            }
            backingArray = backingArrayTemp;
            return true;
        }
        return false;
    }

    /**
     * Retrieves the size, or number of objects in MySet
     * @return an int representing the number of objects in MySet
     */
    public int size() {
        return backingArray.length;
    }

    /**
     * Converts MySet to an Object Array
     * @return an Object array representing the objects of MySet
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        Object[] backingArrayOut = new Object[numElements];
        for (int i = 0; i < (backingArray.length - 1); i++) {
            backingArrayOut[i] = backingArray[i];
        }
        return backingArrayOut;
    }

    /**
     * This method is supposed to convert MySet to an Array of generic type T
     * @param a   runtime type of the array to contain the collection
     * @param <T> generic type T
     * @return null because this method did not need to be implemented
     */
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /*
    ----------------------------------------------
    These methods are provided to help you, DO NOT MODIFY!
    Refer to the slides on Iterators if you want to learn more
    http://cs1331.org/slides/iterators.pdf
    */

    /**
    * Returns an iterator if you wish to use it
    * @return An iterator for the SimpleSet
    */
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator {

        private int index = 0;
        public boolean hasNext() {
            return index < numElements;
        }

        public T next() {
            return backingArray[index++];
        }

        /* public void remove() {
            MySet.this.remove(backingArray[index]);
            index--;
            }*/
    }
}
