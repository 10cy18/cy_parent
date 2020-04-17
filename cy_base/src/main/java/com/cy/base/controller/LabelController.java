package com.cy.base.controller;

/**
 * @Author: cy
 * @Date: 2019/1/22 10:21
 */

import com.cy.base.pojo.Label;
import com.cy.base.service.LabelService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 标签控制层
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private LabelService labelService;

    @Autowired
    private HttpServletRequest request;
    /**
     * 查询全部列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        //获取头信息
       String header = request.getHeader("Authorization");
        System.out.println(header);
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    /**
     * 根据ID查询标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        System.out.println(serverPort);
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(id));
    }

    /**
     *  功能测试
     * （1）测试查询全部数据 使用浏览器测试GET方法 http://localhost:9001/label
     * （2）测试根据ID查询标签
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Label label, @PathVariable String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSereach(@RequestBody Label label) {
        List<Label> list = labelService.findSereach(label);
        return new Result(true, StatusCode.OK, "搜索成功", list);
    }

    /**
     * 条件+分页查询
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageList = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(pageList.getTotalElements(),pageList
                .getContent()));
    }
}
