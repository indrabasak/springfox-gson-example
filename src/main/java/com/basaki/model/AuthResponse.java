package com.basaki.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * {@code AuthResponse} is the response object for {@code AuthController}
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
@ApiModel
@Data
public class AuthResponse {

    private String name;
}
