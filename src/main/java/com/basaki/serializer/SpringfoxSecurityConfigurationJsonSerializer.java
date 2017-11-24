package com.basaki.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.swagger.web.SecurityConfiguration;

public class SpringfoxSecurityConfigurationJsonSerializer
        implements JsonSerializer<SecurityConfiguration> {

    @Override
    public JsonElement serialize(SecurityConfiguration config,
            Type type, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("clientId", config.getClientId());
        jsonObject.addProperty("realm", config.getRealm());
        jsonObject.addProperty("appName", config.getAppName());
        jsonObject.addProperty("apiKey", config.getApiKey());
        jsonObject.addProperty("apiKeyName", config.getApiKeyName());
        jsonObject.addProperty("clientSecret", config.getClientSecret());
        jsonObject.addProperty("scopeSeparator", config.scopeSeparator());
        jsonObject.addProperty("apiKeyVehicle", config.getApiKeyVehicle());

        return jsonObject;
    }
}
