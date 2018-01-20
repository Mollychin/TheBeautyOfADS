package mollychin.week2;

import java.util.Arrays;

public class HeatersTest {

  public static void main(String[] args) {
    int radius = findRadius(new int[]{1, 3, 5}, new int[]{3});
    System.out.println(radius);
  }

  public static int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int result = Integer.MIN_VALUE;

    for (int house : houses) {
      int index = Arrays.binarySearch(heaters, house);
      if (index < 0) {
        index = -(index + 1);
      }
      int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
      int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

      result = Math.max(result, Math.min(dist1, dist2));
    }
    return result;
  }
}
