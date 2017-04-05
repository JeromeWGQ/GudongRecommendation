package com.sportsRecipe.filter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * SESSION 超时拦截
 * 类名称：SessionInterceptor   
 */
public class SessionInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 7579862236766378267L;


	public String intercept(ActionInvocation invocation) throws Exception {
	   ActionContext actx=invocation.getInvocationContext();
	   Object user=actx.getSession().get("sessionUser");

	   if(user!=null){
		   
		   return invocation.invoke();
	   }
	  
	   //如果超时，返回提示页面
	  return "myloginPage";

	}


	@Override
	public void destroy() {
		System.out.println("拦截器销毁");
		super.destroy();
	}


	@Override
	public void init() {
		System.out.println("拦截器启动");
		super.init();
	}
	
	
	
}

