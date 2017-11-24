package com.basaki.config;

import com.basaki.serializer.SpringfoxApiListingJsonSerializer;
import com.basaki.serializer.SpringfoxJsonSerializer;
import com.basaki.serializer.SpringfoxResourceJsonSerializer;
import com.basaki.serializer.SpringfoxResourceListingJsonSerializer;
import com.basaki.serializer.SpringfoxSecurityConfigurationJsonSerializer;
import com.basaki.serializer.SpringfoxUiConfigurationJsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import springfox.documentation.service.ApiListing;
import springfox.documentation.service.ResourceListing;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

/**
 * {@code GsonConfiguration} configures Gson to work with Springfox by adding
 * type adapters (JSON serializers) for different Springfox models and
 * configurations.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
@Configuration
@ConditionalOnClass(Gson.class)
public class GsonConfiguration {

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(getGson());

        return converter;
    }

    public Gson getGson() {
        return new GsonBuilder()
                // needed for making calls to /v2/api-docs
                .registerTypeAdapter(Json.class,
                        new SpringfoxJsonSerializer())
                // rest are needed for making calls to /swagger-ui.html
                .registerTypeAdapter(ApiListing.class,
                        new SpringfoxApiListingJsonSerializer())
                .registerTypeAdapter(SwaggerResource.class,
                        new SpringfoxResourceJsonSerializer())
                .registerTypeAdapter(ResourceListing.class,
                        new SpringfoxResourceListingJsonSerializer())
                .registerTypeAdapter(UiConfiguration.class,
                        new SpringfoxUiConfigurationJsonSerializer())
                // needed if you have security
                .registerTypeAdapter(SecurityConfiguration.class,
                        new SpringfoxSecurityConfigurationJsonSerializer())
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();
    }
}
