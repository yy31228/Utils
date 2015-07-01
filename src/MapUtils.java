/**
 * Created by Yi on 6/30/15.
 */
import java.util.*;
import java.util.stream.Stream;

public class MapUtils {
    public static <K extends Comparable<? super K>, V> Map<K, V>
    sortByKey1_v7 (Map<K, V> map) {
        TreeMap<K, V> mapSorted = new TreeMap<K, V>(map);
        for(Map.Entry<K, V> entry : mapSorted.entrySet())
            System.out.println(entry);
        return mapSorted;
    }

    public static <K extends Comparable<? super K>, V> Map<K, V>
    sortByKey2_v7 (Map<K, V> map) {
        TreeSet<Map.Entry<K, V>> setSorted = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>> () {
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        setSorted.addAll(map.entrySet());
        Map<K, V> mapSorted = new LinkedHashMap<K, V>();
        for(Map.Entry<K, V> entry : setSorted) {
            System.out.println(entry);
            mapSorted.put(entry.getKey(), entry.getValue());
        }
        return mapSorted;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue1_v7 (Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        Map<K, V> mapSorted = new LinkedHashMap<K, V>();
        for(Map.Entry<K, V> entry : list) {
            mapSorted.put(entry.getKey(), entry.getValue());
            System.out.println(entry);
        }
        return mapSorted;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue1_v8 (Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, Comparator.comparing(e -> e.getValue()));
        Map<K, V> mapSorted = new LinkedHashMap<K, V>();
        for(Map.Entry<K, V> entry : list) {
            mapSorted.put(entry.getKey(), entry.getValue());
            System.out.println(entry);
        }
        return mapSorted;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue2_v8 (Map<K, V> map)
    {
        Map<K,V> mapSorted = new LinkedHashMap<>();
        Stream <Map.Entry<K,V>> st = map.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(e -> mapSorted.put(e.getKey(),e.getValue()));
        return mapSorted;
    }

}

