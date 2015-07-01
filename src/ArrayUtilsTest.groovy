import java.lang.reflect.Array

/**
 * Created by Yi on 7/1/15.
 */
class ArrayUtilsTest extends GroovyTestCase {
    void testlistToArray() {
        def names = ["listToArray1_v7", "listToArray2_v7", "listToArray1_v8", "listToArray2_v8"]
        def list = [1, 2, 4, 5]
        names.each { name ->
            println "Test $name"
            int[] rst = ArrayUtils."$name"(list);
            println rst
            assert rst instanceof int[]
            assert list instanceof List<Integer>
        }
    }

    void testArrayToList() {
        def names = ["arrayToList1_v7", "arrayToList2_v7", "arrayToList1_v8", "arrayToList2_v8"]
        Integer[] arr = [1, 2, 4, 5]
        names.each { name ->
            println "Test $name"
            List rst = ArrayUtils."$name"(arr);
            println rst
            assert arr instanceof Integer[]
            assert rst instanceof List<Integer>
        }
    }

    void testArrayToString() {
        def names = ["arrayToString1_v8"]
        int[] arr = [1, 2, 4, 5]
        names.each { name ->
            println "Test $name"
            String rst = ArrayUtils."$name"(arr);
            println rst
            assert rst == "1245"
        }
    }

    void testStringToArray() {
        def names = ["stringToArray1_v8"]
        String str = "1,2,4,5"
        names.each { name ->
            println "Test $name"
            int[] rst = ArrayUtils."$name"(str);
            println rst
            assert rst == [1, 2, 4, 5]
        }
    }
}
