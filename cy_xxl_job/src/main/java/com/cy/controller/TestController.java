package com.cy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyong
 * @version V1.0
 * @ClassName TestController
 * @Description: TODO
 * @date 2020/4/17
 **/
@RestController
public class TestController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/t")
    public String getPort() {
        return "端口：" + port;
    }
}
