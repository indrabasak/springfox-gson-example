package com.basaki.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code PingController} is another simple example controller.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
@RestController
@Slf4j
@Api(description = "Ping Conroller",
        produces = "application/json", tags = {"2"})
public class PingController {

    @ApiOperation(value = "ping")
    @GetMapping(value = "/ping")
    public String ping() {
        return "pong";
    }
}
