package com.cy.user.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cy.user.pojo.User;
import com.cy.user.service.UserService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import util.JwtUtil;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private HttpServletRequest request;
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		Claims claims=(Claims) request.getAttribute("claims_user");
		if(claims==null){
			return new Result(true,StatusCode.ACCESSERROR,"无权访问");
		}
		return new Result(true,StatusCode.OK,"查询成功",userService.findAll());
	}

	/**
	 * 用户登陆
	 * @param *mobile
	 * @param *password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Result login(@RequestBody User u){
		User user = userService.findByMobileAndPassword(u.getMobile(),u.getPassword());
		if(user!=null){
			String token = jwtUtil.createJWT(user.getId(),user.getNickname(), "user");
			Map map=new HashMap();
			map.put("token",token);
			map.put("name",user.getNickname());//昵称
			map.put("avatar",user.getAvatar());//头像
			return new Result(true,StatusCode.OK,"登陆成功",map);
		}else{
			return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
		}
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",userService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
	 * 根据条件查询
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public Result findSearch( @RequestBody Map searchMap){
		return new Result(true,StatusCode.OK,"查询成功",userService.findSearch(searchMap));
	}

	/**
	 * 修改
	 * @param user
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody User user, @PathVariable String id ){
		user.setId(id);
		userService.update(user);
		return new Result(true,StatusCode.OK,"修改成功");
	}

	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		userService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	/**
	 * 发送短信验证码
	 * @param mobile
	 */
	@RequestMapping(value="/sendsms/{mobile}",method=RequestMethod.POST)
	public Result sendsms(@PathVariable String mobile ){
		userService.sendSms(mobile);
		return new Result(true,StatusCode.OK,"发送成功");
	}

	/**
	 * 用户注册
	 * @param user
	 */
	@RequestMapping(value="/register/{code}",method=RequestMethod.POST)
	public Result register( @RequestBody User user ,@PathVariable String code){
		userService.add(user,code);
		return new Result(true,StatusCode.OK,"注册成功");
	}
}
