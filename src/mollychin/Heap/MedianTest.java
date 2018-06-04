package mollychin.Heap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import sun.awt.AWTAccessor.MenuAccessor;

/**
 * Created by Mollychin on 2018/5/28.
 */
public class MedianTest {

  public static void main(String[] args) {
    Median<Integer> integerMedian = new Median<>();
    List<Integer> integers = Arrays
        .asList(new Integer[]{100, 2, 1, 3, 66, 32, 88, 4, 45, 87, 99, 34, 554, 55, 12, 32});
    integerMedian.addAll(integers);
    System.out.println("中位数是："+integerMedian.getM());
  }

}

class Median<E> {

  private PriorityQueue<E> minHeap;
  private PriorityQueue<E> maxHeap;
  private E m;

  public Median() {
    this.minHeap = new PriorityQueue<>();
    this.maxHeap = new PriorityQueue<>();
  }

  private int compare(E e, E m) {
    Comparable<? super E> comparable = (Comparable<? super E>) e;
    return comparable.compareTo(m);
  }

  public void add(E e) {
    // e为第一个数值时
    if (m == null) {
      m = e;
      return;
    }
    if (compare(e, m) <= 0) {
      // 新来的数值小于等于原中值时则加在最大堆里
      maxHeap.add(e);
    } else {
      minHeap.add(e);
    }
    if (minHeap.size() - maxHeap.size() >= 2) {
      maxHeap.add(this.m);
      this.m = minHeap.poll();
    } else if (maxHeap.size() - minHeap.size() >= 2) {
      minHeap.add(this.m);
      this.m = maxHeap.poll();
    }
  }

  public void addAll(Collection<? extends E> c) {
    for (E e : c) {
      add(e);
    }
  }

  public E getM() {
    return m;
  }
}