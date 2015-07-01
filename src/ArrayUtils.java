import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Yi on 7/1/15.
 */
public class ArrayUtils {
    public static <T extends Number> Number[]
    listToArray1_v7(List<T> list) {
        Number[] rst = new Number[list.size()];
        for(int i = 0; i < list.size(); i++)
            rst[i] = list.get(i);
        return rst;
    }

    public static <T extends Number> Number[]
    listToArray2_v7(List<T> list) {
        Number[] rst = list.toArray(new Number[list.size()]);
        return rst;
    }

    public static <T extends Number> Number[]
    listToArray1_v8(List<T> list) {
        Number[] rst = list.stream().toArray(Number[]::new);
        return rst;
    }

    public static int[]
    listToArray2_v8(List<Integer> list) {
        int[] rst = list.stream().mapToInt(Integer::intValue).toArray();
        return rst;
    }

    public static <T extends Number> List<Number>
    arrayToList1_v7(T[] arr) {
        List<Number> rst = new ArrayList<Number>(Arrays.asList(arr));
        return rst;
    }

    public static List<Integer>
    arrayToList2_v7(int[] arr) {
        List<Integer> rst = new ArrayList<Integer>();
        for(int i : arr)
            rst.add(i);
        return rst;
    }

    public static <T extends Number> List<Number>
    arrayToList1_v8(T[] arr) {
        List<Number> rst = Arrays.stream(arr).collect(Collectors.toList());
        return rst;
    }

    public static List<Integer>
    arrayToList2_v8(int[] arr) {
        List<Integer> rst = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return rst;
    }

    public static String
    arrayToString1_v8(int[] arr) {
        String rst = Arrays.stream(arr).boxed().map(String::valueOf).collect(Collectors.joining());
        return rst;
    }

    public static int[]
    stringToArray1_v8(String str) {
        String[] strings = str.split(",");
        int[] rst = Arrays.stream(strings).mapToInt(Integer::valueOf).toArray();
        return rst;
    }
}
