package app;

import java.io.IOException;

public class Functions {
/*
    *//**
     * Parse JSON string to Java object
     *
     * @param json                       json-string
     * @param valueType                  object type
     * @param FAIL_ON_UNKNOWN_PROPERTIES fail if json-string contains unknown properties
     * @return Java Object
     * @throws IOException exception
     *//*
    public <T> T parseJsonString(String json, Class<T> valueType, boolean FAIL_ON_UNKNOWN_PROPERTIES) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(json, valueType);
    }*/
}
