package com.bobocode.cs;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */
public class ArrayList<T> implements List<T> {
    private Object[] list;
    private int size;

    /**
     * This constructor creates an instance of {@link ArrayList} with a specific capacity of an array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */
    public ArrayList(int initCapacity) throws IllegalArgumentException {
        if (initCapacity > 0) {
            this.list = new Object[initCapacity];
        } else {
            throw new IllegalArgumentException("Capacity number is incorrect");
        }
    }

    /**
     * This constructor creates an instance of {@link ArrayList} with a default capacity of an array inside.
     * A default size of inner array is 5;
     */
    public ArrayList() {
        this.list = new Object[5];
    }

    /**
     * Creates and returns an instance of {@link ArrayList} with provided elements
     *
     * @param elements to add
     * @return new instance
     */
    @SafeVarargs
    public static <T> List<T> of(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>();
        Arrays.stream(elements).forEach(arrayList::add);
        return arrayList;
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[size++] = element;
    }

    /**
     * Adds an element to the specific position in the array where
     *
     * @param index   index of position
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }


    /**
     * Retrieves an element by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < size && index >= 0) {
            return (T) list[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public T getFirst() {
        if (list.length != 0 && size != 0) {
            return (T) list[0];
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public T getLast() {
        if (list.length != 0 && size != 0) {
            return (T) list[size - 1];
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   position of value
     * @param element a new value
     */
    @Override
    public void set(int index, T element) {
        if (index < size && index >= 0) {
            list[index] = element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T removedElement = (T) list[index];

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;

        return removedElement;
    }

    /**
     * Checks for existing of a specific element in the list.
     *
     * @param element is element
     * @return If element exists method returns true, otherwise it returns false
     */
    @Override
    public boolean contains(T element) {
        for (Object el : list) {
            if (el == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return amount of saved elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        list = null;
        size = 0;
    }
}
