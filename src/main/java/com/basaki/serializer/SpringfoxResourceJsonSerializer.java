package com.basaki.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.swagger.web.SwaggerResource;

public class SpringfoxResourceJsonSerializer implements JsonSerializer<SwaggerResource> {

    @Override
    public JsonElement serialize(SwaggerResource resource, Type type,
            JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", resource.getName());
        jsonObject.addProperty("location", resource.getLocation());
        jsonObject.addProperty("swaggerVersion", resource.getSwaggerVersion());

        return jsonObject;
    }
}
