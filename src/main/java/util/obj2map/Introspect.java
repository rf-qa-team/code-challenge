package util.obj2map;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;


import java.util.Map;

/**
 * Class that containsmethods with serialisation Object to Map.
 */

public final class Introspect {
    private Introspect() {
    }

    /**
     * convert Object to Map.
     */
    @SneakyThrows
    public static Map<String, Object> introspect(Object obj) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(obj, Map.class);
    }

    /**
     * Convert map to object.
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> classOfT) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(map, classOfT);

    }


}
