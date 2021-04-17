package app;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

  private int size;
  private Node<T> head = null;
  private Node<T> tempHeadPointer;

  public RecursiveList() {
    this.head = null;
    this.size = 0;
  }

  public RecursiveList(Node<T> first) {
    this.head = first;
    this.size = 1;
  }

  /**
   * @function : Returns the current size of the Linked List
   * @return size : Holds the current size of the Linked List
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * @function : Inserts an element at the starting of the Linked List
   * @param elem : The data that has to be stored in the new node
   * @throws NullPointerException if elem is null
   */
  @Override
  public void insertFirst(T elem) throws NullPointerException {
    if (elem == null) {
      throw new NullPointerException();
    }
    Node<T> new_node = new Node<T>(elem, null);
    new_node.setNext(head);
    head = new_node;
    this.size++;
  }

  /**
   * @function : Inserts an element at the end of the Linked List
   * @param elem : The data that has to be stored in the new node
   * @throws NullPointerException if elem is null
   */
  @Override
  public void insertLast(T elem) {
    if (elem == null) {
      throw new NullPointerException();
    }
    Node<T> newNode = new Node<T>(elem, null);
    if (head == null) {
      head = newNode;
    } else {
      tempHeadPointer = head;
      Node<T> lastNode = getSpecificNode(this.size - 1, tempHeadPointer);
      lastNode.setNext(newNode);
    }
    this.size++;
  }

  /**
   * @function : Inserts an element, at the given index, in the Linked List
   * @param index : The index ta which the node must be inserted
   * @param elem  : The data that has to be stored in the new node
   * @throws NullPointerException      if elem is null
   * @throws IndexOutOfBoundsException if invalid index is passed
   */
  @Override
  public void insertAt(int index, T elem) {
    Node<T> newNode = new Node<T>(elem, null);
    if (elem == null) {
      throw new NullPointerException();
    }
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0 || head == null) {
      insertFirst(elem);
    } else if (index == this.size) {
      insertLast(elem);
    } else {
      tempHeadPointer = head;
      Node<T> prevNode = getSpecificNode(index - 1, tempHeadPointer);
      newNode.setNext(prevNode.getNext());
      prevNode.setNext(newNode);
      this.size++;
    }
  }

  /**
   * @function : Removes the first node of the Linked List and returns the data
   *           present in that node
   * @throws IllegalStateException if the List is empty
   * @return removedItem : The data present in the removed node.
   */
  @Override
  public T removeFirst() {
    T removedItem = null;
    if (size == 0) {
      throw new IllegalStateException();
    } else {
      removedItem = head.getData();
      head = head.getNext();
      this.size--;
    }
    return removedItem;
  }

  /**
   * @function : Removes the last node of the Linked List and returns the data
   *           present in that node
   * @throws IllegalStateException if the List is empty
   * @return removedItem : The data present in the removed node.
   */
  @Override
  public T removeLast() {
    T removedItem = null;

    if (this.size == 0) {
      throw new IllegalStateException();
    }
    if (this.size == 1) {
      removedItem = head.getData();
      head = null;
    } else {
      Node<T> penultimateNode = null;
      penultimateNode = getSpecificNode(this.size - 2, tempHeadPointer);
      removedItem = penultimateNode.getNext().getData();
      penultimateNode.setNext(null);
    }
    this.size--;
    return removedItem;
  }

  /**
   * @function : Removes the first node of the Linked List and returns the data
   *           present in that node
   * @param i : Holds the index of the node to be deleted
   * @throws IndexOutOfBoundsException if invalid index is passed
   * @return removedItem : The data present in the removed node.
   */
  @Override
  public T removeAt(int i) {
    T removedItem = null;

    if (i < 0 || i >= this.size) {
      throw new IndexOutOfBoundsException();
    }

    if (i == 0) {
      removeFirst();
    } else if (i == this.size - 1) {
      removeLast();
    } else {
      tempHeadPointer = head;
      Node<T> removedNode = getSpecificNode(i, tempHeadPointer);
      Node<T> prevNode = getSpecificNode(i - 1, tempHeadPointer);
      removedItem = removedNode.getData();
      prevNode.setNext(removedNode.getNext());
      this.size--;
    }
    return removedItem;
  }

  /**
   * @function : Fetches the first node of the Linked List.
   * @throws IllegalStateException if the list is empty
   * @return item : The data present in the required node.
   */
  @Override
  public T getFirst() {
    T item = null;
    if (this.size == 0) {
      throw new IllegalStateException();
    } else {
      item = head.getData();
    }
    return item;
  }

  /**
   * @function : Fetches the last node of the Linked List.
   * @throws IllegalStateException if the list is empty
   * @return item : The data present in the required node.
   */
  @Override
  public T getLast() {
    T item = null;
    if (size == 0) {
      throw new IllegalStateException();
    } else {
      tempHeadPointer = head;
      item = getSpecificNode(this.size - 1, tempHeadPointer).getData();
    }
    return item;
  }

  /**
   * @function : Fetches the node present at the provided index in the Linked
   *           List.
   * @param i : Holds the index of the node to be fetched
   * @throws IndexOutOfBoundsException if invalid index is passed
   * @return item : The data present in the required node.
   */
  @Override
  public T get(int i) {
    T item = null;

    if (i == 0) {
      item = getFirst();
    } else if (i == this.size - 1) {
      item = getLast();
    } else {
      tempHeadPointer = head;
      item = getSpecificNode(i, tempHeadPointer).getData();
    }
    return item;
  }

  /**
   * @function : Helper method for the get(i) method that fetches the node present
   *           at the provided index in the Linked List.
   * @param i        : Holds the index of the node to be fetched
   * @param currNode : Refers to the current node
   * @throws IndexOutOfBoundsException if invalid index is passed
   * @return resNode : The required node.
   */
  private Node<T> getSpecificNode(int i, Node<T> currNode) {
    Node<T> resNode = null;
    if (i < 0 || i >= this.size) {
      throw new IndexOutOfBoundsException();
    }

    if (i == 0) {
      resNode = currNode;
    } else {
      resNode = getSpecificNode(i - 1, currNode.getNext());
    }
    currNode = head;
    return resNode;
  }

  /**
   * @function : Removes elem from the List, if it exists.
   * @param elem : The elemnt to search for and remove
   * @throws NullPointerException  if elem is null
   * @throws ItemNotFoundException if elem is not found in the List
   */
  @Override
  public void remove(T elem) {
    if (elem == null) {
      throw new NullPointerException();
    }
    tempHeadPointer = head;
    int index = indexOfHelperMethod(tempHeadPointer, elem, 0);
    if (index == -1) {
      throw new ItemNotFoundException();
    } else {
      removeAt(index);
    }
  }

  /**
   * @function : Returns the smallest index which contains elem. If there is no
   *           instance of elem in the list, then -1 is returned.
   * @param i    : Holds the index of the node to be fetched
   * @param elem : The elemnt to search for
   * @throws NullPointerException if elem is null
   * @return index : The smallest index which contains elem or -1 if elem is not
   *         present in the List.
   */
  @Override
  public int indexOf(T elem) {
    if (elem == null) {
      throw new NullPointerException();
    } else {
      tempHeadPointer = head;
      int index = indexOfHelperMethod(tempHeadPointer, elem, 0);
      return index;
    }
  }

  /**
   * @function : Helper method to assist the indexOf method, that fetches the
   *           index of the first occurrence of the provided element in the Linked
   *           List
   * @param :        Holds the index of the node to be fetched
   * @param currNode : Refers to the current node
   * @param currNode : The elemnt that has to be searched for in the List
   * @param pos      : The current position that is being evaluated
   * @return index : The index of the required node.
   */
  private int indexOfHelperMethod(Node<T> currNode, T elem, int pos) {
    int index = 0;
    if (currNode == null) {
      return -1;
    }
    if (currNode.getData() == elem) {
      index = pos;
      ;
    } else {
      index = indexOfHelperMethod(currNode.getNext(), elem, pos + 1);
    }
    return index;
  }

  /**
   * @function : Checks if the List is empty or not
   * @return empty : true if list is empty, else returns false
   */
  @Override
  public boolean isEmpty() {
    boolean empty = false;
    if (head == null) {
      empty = true;
    }
    return empty;
  }

  /**
   * @function : Returns an Iterator object that will traverse this list
   * @return iter : Object of the iterator class
   */
  public Iterator<T> iterator() {
    Iterator<T> iter = new Iterator<T>() {

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public T next() {
        return null;
      }
    };
    return iter;
  }
}
