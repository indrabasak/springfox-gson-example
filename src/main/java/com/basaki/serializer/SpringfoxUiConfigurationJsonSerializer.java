package com.basaki.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.swagger.web.UiConfiguration;

/**
 * {@code SpringfoxUiConfigurationJsonSerializer} is a JSON serializer for
 * Springfox's {@code UiConfiguration} class.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
public class SpringfoxUiConfigurationJsonSerializer
        implements JsonSerializer<UiConfiguration> {

    @Override
    public JsonElement serialize(UiConfiguration config, Type type,
            JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("validatorUrl", config.getValidatorUrl());
        jsonObject.addProperty("docExpansion", config.getDocExpansion());
        jsonObject.addProperty("apisSorter", config.getApisSorter());
        jsonObject.addProperty("defaultModelRendering",
                config.getDefaultModelRendering());

        JsonArray array = new JsonArray();
        for (String value : config.getSupportedSubmitMethods()) {
            array.add(new JsonPrimitive(value));
        }

        jsonObject.add("supportedSubmitMethods", array);
        jsonObject.addProperty("jsonEditor", config.isJsonEditor());
        jsonObject.addProperty("showRequestHeaders",
                config.isShowRequestHeaders());
        jsonObject.addProperty("requestTimeout", config.getRequestTimeout());

        return jsonObject;
    }
}
