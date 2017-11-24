package com.basaki.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * {@code SwaggerConfiguration} is the configuration for setting up swagger for
 * the author controller. The swagger documentation can be viewed at {@code
 * http://<host>:<port>/swagger-ui.html} and {@code <host>:<port>/v2/api-docs?group=gson}
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
@Configuration
@Import({BeanValidatorPluginsConfiguration.class, SpringDataRestConfiguration.class})
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Creates the Swagger configuration bean.
     *
     * @return docket bean
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("gson")
                .select()
                .paths(matchPathRegex("/books(/|$).*",
                        "/booxs(/|$).*", "/auths(/|$).*",
                        "/ping(/|$).*"))
                .build()
                .apiInfo(apiInfo("Example of Spring Boot, Springfox, and Gson",
                        "Example Springfox Gson API"));
    }

    /**
     * Creates an object containing API information including author name,
     * email, version, license, etc.
     *
     * @param title       API title
     * @param description API description
     * @return API information
     */
    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .build();
    }

    private static Predicate<String> matchPathRegex(
            final String... pathRegexs) {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                for (String pathRegex : pathRegexs) {
                    if (input.matches(pathRegex)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
}
