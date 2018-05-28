package mollychin.Heap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Mollychin on 2018/5/28.
 */
public class TopKTest {

  public static void main(String[] args) {
    TopK<Integer> top5 = new TopK<>(5);
    List<Integer> integers = Arrays
        .asList(new Integer[]{100, 2, 1, 3, 66, 32, 88, 4, 45, 87, 99, 34, 554, 55, 12, 32});
    top5.addAll(integers);
    System.out.println("保留5个最大的元素，输出为：");
    System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
    System.out.println(top5.getKth());
  }
}


class TopK<E> {

  private PriorityQueue<E> p;
  private int k;

  /**
   * 构造器.
   */
  public TopK(int k) {
    this.k = k;
    this.p = new PriorityQueue<>(k);
  }

  /**
   * 添加集合中的所有元素.
   */
  public void addAll(Collection<? extends E> c) {
    for (E e : c) {
      add(e);
    }
  }

  public void add(E e) {
    // 堆未满，直接加入
    if (p.size() < k) {
      p.add(e);
      return;
    }
    Comparable<? super E> heap = (Comparable<? super E>) p.peek();
    //新来的小于根节点，不做什么东西
    if (heap.compareTo(e) > 0) {
      return;
    }
    // 新来的大于根节点，把根节点抛弃，加入新来的数值
    p.poll();
    p.add(e);
  }

  public <T> T[] toArray(T[] a) {
    return p.toArray(a);
  }

  /**
   * 返回第K大的值.
   */
  public E getKth() {
    return p.peek();
  }
}