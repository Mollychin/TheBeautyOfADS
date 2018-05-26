package mollychin.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mollychin on 2018/4/17.
 */
public class FastFailTest {

  private static List<String> list = new ArrayList();
  public static void main(String[] args) {

    new ThreadOne().start();
    new ThreadTwo().start();
  }

  private static void printAll() {
    System.out.println("");
    String value = null;
    Iterator iterator = list.iterator();
    while(iterator.hasNext()) {
      value = (String)iterator.next();
      System.out.print(value+", ");
    }
  }

  private static class ThreadOne extends Thread {
    public void run() {
      int i = 0;
      while (i<6) {
        list.add(String.valueOf(i));
        printAll();
        i++;
      }
    }
  }

  private static class ThreadTwo extends Thread {
    public void run() {
      int i = 10;
      while (i<16) {
        list.add(String.valueOf(i));
        printAll();
        i++;
      }
    }
  }
}
