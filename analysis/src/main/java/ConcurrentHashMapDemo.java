import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConcurrentHashMapDemo {

    private Map<Integer,Integer> cache  = new ConcurrentHashMap<Integer, Integer>();

    public static void main(String[] args) {

        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        System.out.println(demo.getValue(80));
    }

    public int getValue(Integer key) {
        if ( key ==0 || key == 1) {
            return key;
        }

        return cache.computeIfAbsent(key, integer -> {
            System.out.println(" key==" + integer);

            return  getValue(integer -1) + getValue(integer-2);
        } );
    }

}
