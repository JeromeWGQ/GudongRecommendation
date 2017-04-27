package com.sportsRecipe.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.ServletActionContext;


public class BaseAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	
	protected static final String SESSION_TIMEOUT = "sessionTimeout"; // 用于系统超时时,struts.xml自动把action重定向到指定页
	protected static final String SESSION_TIMEOUT_JSON_TEXT = "抱歉, 用户 session 超时,请退出重新登陆";
	
	/*Map session = ActionContext.getContext().getSession();

    
	*//**
	 * 返回在session中的普通用户
	 * @return
	 *//*
	
	public User getSessionUser(){
		
		if (session.get("sessionUser")!=null){
			return (User)session.get("sessionUser");
		}
		return null;
	}*/


	/**
	 * 生成上传文件的保存路径 , 输入文件名,和要保存的路径,会放在upload下的folder内
	 * @param folder
	 * @param fileName
	 * @return
	 */
	/*public String generateUploadPath(String folder , String fileName){
		//windows 下面的路径
		//String savePath = ServletActionContext.getServletContext().getRealPath("/upload\\" + folder + "\\") + "\\" + fileName;
		
		//liunx下面的路径
		String savePath = ServletActionContext.getServletContext().getRealPath("/upload/" + folder ) + "/" + fileName;
		return savePath;
	}*/
		

}
