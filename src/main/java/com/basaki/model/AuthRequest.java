package com.basaki.model;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * {@code AuthRequest} is an example model for showing Springfox Support for
 * JSR-303.In version greater than 2.3.2 It supports bean validation annotations
 * specifically for @NotNull, @Min, @Max, and @Size..
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
@ApiModel
@Data
public class AuthRequest {
    //@ApiModelProperty(required = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    //@ApiModelProperty(required = true)
    @NotNull
    private String password;
}
