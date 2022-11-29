package util.helper;

import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static util.obj2map.Introspect.introspect;

/**
 * Static methods that could be helpfull in several places.
 */
public final class Assertation {
    private Assertation() {
    }

    /**
     * Assert that all fields that are present in datatable are matched with object param and params are not null.
     *
     * @param table  'List< List< String > >'.
     * @param object object class with fields.
     */
    public static void assertKeyAndNotNullValue(List<List<String>> table, Object object) {
        Map<String, Object> map = introspect(object);
        for (List<String> columns : table) {
            String field = columns.get(0);
            Assert.assertTrue(map.containsKey(field), field + " is not find. Object map:\n" + Arrays.toString(map.entrySet().toArray()));
            Assert.assertNotNull(map.get(field), field + " value is NUll. Object map:\n" + Arrays.toString(map.entrySet().toArray()));
        }
    }

    /**
     * Check that Map and Object are identical.
     */
    public static void assertMapIsEqualToObject(List<List<String>> table, Object object) {
        Map<String, Object> map = introspect(object);
        for (List<String> columns : table) {
            String field = columns.get(0);
            String value = columns.get(1);
            Assert.assertTrue(map.containsKey(field), field + " is not find.Object map:\n" + Arrays.toString(map.entrySet().toArray()));
            Assert.assertNotNull(map.get(field), field + "value is emptyObject map:\n" + Arrays.toString(map.entrySet().toArray()));
            Assert.assertEquals(map.get(field).toString(), value,
                    "Values are not equal. Field: " + field + " Expected: " + map.get(field).toString() + " Actual: " + value);
        }

    }

}
