package com.cy.qa.client.impl;

import org.springframework.stereotype.Component;

import com.cy.qa.client.LabelClient;

import entity.Result;
import entity.StatusCode;

/**
 * @Author: cy
 * @Date: 2019/2/21 17:01
 */
@Component
public class LabelClientImpl implements LabelClient{

    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
