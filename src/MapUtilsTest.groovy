/**
 * Created by Yi on 6/30/15.
 */
class MapUtilsTest extends GroovyTestCase {
    def map = [1:5,2:4,3:1,0:8]

    void testSortByKey() {
        def names = ["sortByKey1_v7", "sortByKey2_v7"]
        names.each {name ->
            println "Test ${name}"
            def mapSorted = MapUtils."${name}"(map);
            def prev = -1;
            mapSorted.keySet().each { i ->
                assert i >= prev
                prev = i
            }
        }
    }

    void testSortByValue() {
        def names = ["sortByValue1_v7", "sortByValue1_v8", "sortByValue1_v8"]
        names.each {name ->
            println "Test ${name}"
            def mapSorted = MapUtils."${name}"(map);
            def prev = -1
            mapSorted.values().each { i ->
                assert i >= prev
                prev = i
            }
        }
    }

}
