package app;

import java.util.Iterator;

/**
 * A {@link ListInterface} is a container that supports insertion, removal, and
 * searching.
 * 
 * @param <T> : generic type
 */
public interface ListInterface<T> extends Iterable<T> {

  /**
   * Returns the number of elements in this {@link ListInterface}. This method
   * runs in O(1) time.
   */
  public int size();

  /**
   * Adds an element to the front of this {@link ListInterface}. This method runs
   * in O(1) time. For convenience, this method returns the {@link ListInterface}
   * that was modified.
   * 
   * @param elem the element to add
   * 
   * @throws NullPointerException if {@code elem} is {@code null}
   * @throws Exception            if
   */
  public void insertFirst(T elem);

  /**
   * Adds an element to the end of this {@link ListInterface}. This method runs in
   * O(size) time. For convenience, this method returns the {@link ListInterface}
   * that was modified.
   * 
   * @param elem the element to add
   * @throws NullPointerException if {@code elem} is {@code null}
   */
  public void insertLast(T elem);

  /**
   * Adds an element at the specified index such that a subsequent call to
   * {@link ListInterface#get(int)} at {@code index} will return the inserted
   * value. This method runs in O(index) time.
   * 
   * @param index the index to add the element at
   * @param elem  the element to add
   * @throws NullPointerException      if {@code elem} is {@code null}
   * @throws IndexOutOfBoundsException if {@code index} is less than 0 or greater
   *                                   than {@link ListInterface#size()}
   */
  public void insertAt(int index, T elem);

  /**
   * Removes the first element from this {@link ListInterface} and returns it.
   * This method runs in O(1) time.
   * 
   * @return the removed element
   * @throws IllegalStateException if the {@link ListInterface} is empty.
   */
  public T removeFirst();

  /**
   * <p>
   * Removes the last element from this {@link ListInterface} and returns it. This
   * method runs in O(size) time.
   * </p>
   * 
   * @return the removed element
   * @throws IllegalStateException if the {@link ListInterface} is empty.
   */
  public T removeLast();

  /**
   * Removes the ith element in this {@link ListInterface} and returns it. This
   * method runs in O(i) time.
   * 
   * @param i the index of the element to remove
   * @return The removed element
   * @throws IndexOutOfBoundsException if {@code i} is less than 0 or {@code i} is
   *                                   greater than or equal to
   *                                   {@link ListInterface#size()}
   */
  public T removeAt(int i);

  /**
   * Returns the first element in this {@link ListInterface}. This method runs in
   * O(1) time.
   * 
   * @return the first element in this {@link ListInterface}.
   * @throws IllegalStateException if the {@link ListInterface} is empty.
   */
  public T getFirst();

  /**
   * Returns the last element in this {@link ListInterface}. This method runs in
   * O(size) time.
   * 
   * @return the last element in this {@link ListInterface}.
   * @throws IllegalStateException if the {@link ListInterface} is empty.
   */
  public T getLast();

  /**
   * Returns the ith element in this {@link ListInterface}. This method runs in
   * O(i) time.
   * 
   * @param i the index to lookup
   * @return the ith element in this {@link ListInterface}.
   * @throws IndexOutOfBoundsException if {@code i} is less than 0 or {@code i} is
   *                                   greater than or equal to
   *                                   {@link ListInterface#size()}
   */
  public T get(int i);

  /**
   * Removes {@code elem} from this {@link ListInterface} if it exists. If
   * multiple instances of {@code elem} exist in this {@link ListInterface} the
   * one associated with the smallest index is removed. This method runs in
   * O(size) time.
   * 
   * @param elem the element to remove
   * @throws NullPointerException  if {@code elem} is {@code null}
   * @throws ItemNotFoundException if {@code elem} is not in the list.
   */
  public void remove(T elem);

  /**
   * Returns the smallest index which contains {@code elem}. If there is no
   * instance of {@code elem} in this {@link ListInterface} then -1 is returned.
   * This method runs in O(size) time.
   * 
   * @param elem the element to search for
   * @return the smallest index which contains {@code elem} or -1 if {@code elem}
   *         is not in this {@link ListInterface}
   * @throws NullPointerException if {@code elem} is {@code null}
   */
  public int indexOf(T elem);

  /**
   * Returns {@code true} if this {@link ListInterface} contains no elements and
   * {@code false} otherwise. This method runs in O(1) time.
   * 
   * @return {@code true} if this {@link ListInterface} contains no elements and
   *         {@code false} otherwise.
   */
  public boolean isEmpty();

  /**
   * Returns an Iterator object that will traverse this list.
   * 
   * @return an Iterator object.
   */
  public Iterator<T> iterator();

}
