package mollychin.sort;

/**
 * Created by Mollychin on 2018/5/26.
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] ints = {4,1, 3, 2, 8};
    bubbleSort(ints, ints.length);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  /**
   *冒泡排序.
   */
  static void bubbleSort(int arr[], int n) {
    int temp;
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
