package mollychin.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Mollychin on 2018/4/17.
 */
public class HashMapTest {

  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap();
    map.put("语文", 1);
    map.put("数学", 2);
    map.put("英语", 3);
    map.put("历史", 4);
    map.put("政治", 5);
    map.put("地理", 6);
    map.put("生物", 7);
    map.put("化学", 8);
    Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
    while(iterator.hasNext()){
      Entry<String, Integer> entry = iterator.next();
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key+":"+value);
    }
  }
}
