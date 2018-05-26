package mollychin.sort;

/**
 * Created by Mollychin on 2018/5/26.
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] ints = {1, 3, 2, 6, 4, 8, 5};
    ascSort(ints);
    for (int i : ints) {
      System.out.println(i);
    }
  }

  /**
   * 类似于打扑克牌时候的理牌动作.
   */
  public static void ascSort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      int get = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > get) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = get;
    }
  }
}
