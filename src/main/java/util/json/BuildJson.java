package util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public final class BuildJson {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private BuildJson() {
    }

    /**
     * deserialize object to string.
     *
     * @param obj object that will be deserialized to json string.
     * @return json string.
     */
    @SneakyThrows
    public static String fromJsonObject(Object obj) {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return OBJECT_MAPPER.writeValueAsString(obj);
    }


    /**
     * serialise string to object.
     *
     * @param json     string json.
     * @param classOfT type of class.
     * @return return class instance.
     */
    @SneakyThrows
    public static <T> T toJsonObject(String json, Class<T> classOfT) {
        OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return OBJECT_MAPPER.readValue(json, classOfT);
    }
}
