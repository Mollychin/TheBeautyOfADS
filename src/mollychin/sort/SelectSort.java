package mollychin.sort;

/**
 * Created by Mollychin on 2018/5/26.
 */
public class SelectSort {

  public static void main(String[] args) {

  }
  public static void selectionSort(Comparable[] a) {
    int length = a.length;
    int min;
    Comparable temp;
    for (int i = 0; i < length; i++) {
      min = i;
      for (int j = i + 1; j < length; j++) {
        if (a[j].compareTo(a[min]) < 0) {
          min = j;
        }
      }
      temp = a[min];
      a[min] = a[i];
      a[i] = temp;
    }
  }

}
