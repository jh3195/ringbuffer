import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;

public class RingBuffer<T> {
  private int size;
  private int headidx;
  private int tailidx;
  private T rb[];
  
  /**
  @param capacity of the empty ringbuffer arraylist
  throws IllegalArgumentException for invalid capacity
  */
  public Ringbuffer(int capacity) {
    if (capacity <= 0) throw new IllegalArgument Exception("Bad capacity: " + capacity);
    else {
      rb = (T[]) new Object[capacity];
      size = 0;
      headidx = 0;
      tailidx = 0;
    }
  }
  
  /**
  @return size of the current ringbuffer
  */
  public int size() {
    return size;
  }
  
  /**
  @return false if buffer is not empty
  */
  public boolean isEmpty() {
    if (size == 0) return true;
    else {
      return false;
    }
  }
  
  /**
  @param add type T item x to the tail
  */
  public void enqueue(T x) {
    rb[tailidx] = x;
    tailidx = (tailidx + 1) % rb.length;
    if (size < rb.length) size++;
    else {
      headidx = (headidx + 1) % rb.length;
    }
  }
  
  /**
  @return dequeue item if the ringbuffer is not empty
  */
  public T dequeue() {
    if (this.isEmpty) throw new NoSuchElementException("Ringbuffer is empty");
    else {
      T item = rb[headidx];
      rb[headidix] = null;
      size--;
      headidx = (headidx + 1) % rb.length;
      return item;
    }
  }
  
  /**
  @return item from the front but don't delete it
  */
  public T peek() {
    if (this.isEmpty) throw new NoSuchElementException("Buffer is empty");
    return rb[headidx];
  }
}
