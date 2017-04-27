package com.sportsRecipe.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.service.UserlogininfoService;
import com.sportsRecipe.util.GenerateId;
import com.sportsRecipe.util.MD5keyBean;
import com.sportsRecipe.util.ResultUtils;


/**
 * 
 * 模块：登陆校验
 * 数据库：t_user
 */
public class UserinfoAction extends BaseAction {
	protected Log log = LogFactory.getLog(UserinfoAction.class);
	private static final long serialVersionUID = 1L;
	private HttpServletRequest hsr; 
	//private PageManager page=new PageManager(10);
	private UserlogininfoService userlogininfoService; 
	//private RoleService roleService;
	//private AclService aclService;
	//private TUserLoginService tUserLoginService;

	private Userlogininfo data;

	//private Integer id;
	//private int userId;
	//private int roleId;
	//private int orderNo;
	private String username;
	private String password;
	//private String tokenId;



	/*public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	 */
	private List list;
	

	public UserlogininfoService getUserlogininfoService() {
		return userlogininfoService;
	}

	public void setUserlogininfoService(UserlogininfoService userlogininfoService) {
		this.userlogininfoService = userlogininfoService;
	}

	private int result; 	//返回类型
	private String msg;

	/**
	 * 用户名密码是否为空的校验，为空的话execute就不会执行
	 * 只要加载本类，就会马上执行本方法，之后执行execute()方法
	 */
	public void validate() {
		if(username==null ||  "".equals(username) ){
			this.addActionMessage("用户名不能为空！");
		}
		if(password==null ||  "".equals(password) ){
			this.addActionError("密码不能为空！");
		}
	}

	/**
	 * 用户名密码是否正确的校验
	 */
	public String execute() throws Exception {
		//session.put("username", username);
		data=userlogininfoService.findUser(username);
		MD5keyBean md5keyBean=new MD5keyBean();
		if(data == null){
			this.addActionMessage("没有这个用户");
			return INPUT;
		}else if(!data.getPassword().equals(md5keyBean.getkeyBeanofStr(password))){
			this.addActionError("用户密码错误！");
			return INPUT;
		}
		return SUCCESS;
	}

	//注册
	public String register(){
		System.out.println("username");
		return SUCCESS;

	}

	//手机用户登陆
	public void user_login() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";
		data=userlogininfoService.findUser(username);
		MD5keyBean md5keyBean=new MD5keyBean();
		if(data == null){
			status = "-1";
		}else if(!data.getPassword().equals(md5keyBean.getkeyBeanofStr(password))){
			status = "-2";
		}else{
			status = "1";
		}

		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
	}

	//手机用户注册
	public void user_register() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";
		data=userlogininfoService.findUser(username);

		if(data !=null){
			status="-1";
		}else{
			Userlogininfo userinfo = new Userlogininfo();
			MD5keyBean md5keyBean=new MD5keyBean();
			userinfo.setUsername(username);
			userinfo.setPassword(md5keyBean.getkeyBeanofStr(password));
			String id = GenerateId.getUUID();
			userinfo.setUserId(id.substring(id.length()-20, id.length()));
			userlogininfoService.save(userinfo);
			status = "1";
		}

		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
	}

	/******************************************************************************************************
	 * 封装字段
	 */
	public HttpServletRequest getHsr() {
		return hsr;
	}

	public void setHsr(HttpServletRequest hsr) {
		this.hsr = hsr;
	}



	/*public User getData() {
			return data;
		}

		public void setData(User data) {
			this.data = data;
		}*/

	/*public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(int orderNo) {
			this.orderNo = orderNo;
		}*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Userlogininfo getData() {
		return data;
	}

	public void setData(Userlogininfo data) {
		this.data = data;
	}


}
