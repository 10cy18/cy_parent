package com.cy.qa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cy.qa.client.impl.LabelClientImpl;

import entity.Result;

/**
 * @Author: cy
 * @Date: 2019/2/21 16:23
 */
@FeignClient(value="cy-base",fallback = LabelClientImpl.class)
public interface LabelClient {
    @RequestMapping(value="/label/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}
