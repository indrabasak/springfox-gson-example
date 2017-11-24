package com.basaki.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

public class SpringfoxJsonSerializer implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json json, Type type,
            JsonSerializationContext jsonSerializationContext) {
        JsonParser parser = new JsonParser();
        return parser.parse(json.value());
    }
}
