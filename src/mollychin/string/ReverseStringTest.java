package mollychin.string;

public class ReverseStringTest {

  public static void main(String[] args) {
    String mlq = reverseString2("hello");
    System.out.println(mlq);
  }

  /**
   * using StringBuffer.
   */
  public static String reverseString1(String target) {
    String s = new StringBuffer(target).reverse().toString();
    return s;
  }

  /**
   * A original method.
   */
  public static String reverseString2(String target) {
    byte[] bytes = target.getBytes();
    for (int i = 0; i < bytes.length / 2; i++) {
      byte temp = bytes[i];
      bytes[i] = bytes[bytes.length - 1 - i];
      bytes[bytes.length - 1 - i] = temp;
    }
    return new String(bytes);
  }
}
