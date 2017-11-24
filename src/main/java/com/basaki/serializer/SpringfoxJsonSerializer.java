package com.basaki.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

/**
 * {@code SpringfoxJsonSerializer} is a JSON serializer for
 * Springfox's {@code Json} class.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
public class SpringfoxJsonSerializer implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json json, Type type,
            JsonSerializationContext jsonSerializationContext) {
        JsonParser parser = new JsonParser();
        return parser.parse(json.value());
    }
}
