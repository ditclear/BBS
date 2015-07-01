package bbs.vienan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bbs.vienan.bean.User;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.biz.impl.UserBizImpl;
import bbs.vienan.util.MyException;
//import bbs.weiyixing.util.HibernateSessionFactory;
@Scope("prototype") 
@Controller("userAction")
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String repassword;
	private String sex;
	private long age;
	private long userId;
	private Date birthDay;
	private long popedom;
	private long integral;
	private String images;
	public User loginuser;
	private File uploadFile;
    private String uploadFileFileName; 
    private String allowTypes;
    private String uploadFileContentType;
    private String filename;
    private InputStream downloadFile;
    private String name;
    @Autowired
    @Qualifier("userBiz")
    private UserBiz userBiz;
	public void validateRegister(){
		String filterResult=filterTypes(getAllowTypes().split(","));
		if(filterResult!=null){
			this.addFieldError("upload","上传文件类型出错");
		}
		if(birthDay==null){
			this.addFieldError("birthDay","日期类型不合法");
		}
		}
		
	public String login() throws Exception{
		System.out.println("login方法");
		
		ActionContext ac=ActionContext.getContext();
		Integer counter=(Integer) ac.getApplication().get("counter");
		if(counter==null){
			counter=1;
		}else{
			counter=counter+1;
		}
		ac.getApplication().put("counter", counter);
		if(username.equals("admin"))  throw new MyException("这是我自定义的异常");
		if(username.equals("select")||username.equals("from")||username.equals("users")){
			throw new java.sql.SQLException("用户名不能为"+username);
		}
		
		loginuser=userBiz.findAll(new User(username,password));
		ac.getSession().put("loginuser", loginuser);
		if(loginuser!=null)
			System.out.println(loginuser.toString());
		ac.getSession().put("tip", getText("successTip",new String[]{ username}));
		return "success";
	}
	public String logout(){
		ActionContext ac=ActionContext.getContext();
		ac.getSession().put("loginuser", null);
		return "success";
	}
	public String register() throws IOException{
		String targetDirectory=ServletActionContext.getServletContext().getRealPath("/upload");
		File dir=new File(targetDirectory);
		if(!dir.exists()){
			dir.mkdir();
		}
		File target=new File(dir,uploadFileFileName);
		FileUtils.copyFile(uploadFile, target);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setPopedom(4L);
		user.setIntegral(200L);
		user.setBirthday(birthDay);
		user.setImages(uploadFileFileName);
		ActionContext ac=ActionContext.getContext();
		String alert="用户名已存在，请输入其它用户名!";
		if(userBiz.cherlLongin(username)){
			addActionError(alert);
			return "error";
		}
		boolean flag=userBiz.addUser(user);
		if(flag){
			return "success";
		}else{
			return "error";
		}
	}
	public String modify() throws Exception{
		User user=new User();
		user.setUserid(userId);
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setBirthday(birthDay);
		user.setImages(images);
		user.setIntegral(integral);
		user.setPopedom(popedom);
		ActionContext ac=ActionContext.getContext();
		if(userBiz.updateUser(user)){
			loginuser=userBiz.findAll(new User(username, password));
			ac.getSession().put("loginuser", loginuser);
			return "success";
		}
		return "error";
	}
	public String userNameOnly() throws IOException{
	       HttpServletRequest request = ServletActionContext.getRequest();
	       String name=request.getParameter("name");
	       System.out.println(name);
	       boolean result=false;
	       if( userBiz.cherlLongin(name)){
	            result=true;
	       }
	      ServletActionContext.getResponse().getWriter().print(result);
	      return null;
	}

	public String download() throws FileNotFoundException{
		System.out.println(filename);
		if(filename!=null){
		downloadFile=new FileInputStream(new File(ServletActionContext.getServletContext().getRealPath("/upload")+"/"+filename));
		}
		return "success";

	}
	
	public String getDownloadFileName() {  
        String downFileName = filename;  
        if(filename!=null){
        try {
            downFileName = new String(downFileName.getBytes(), "ISO8859-1");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
		}	
        return downFileName;   
  
    }  
	public String filterTypes(String[] types){
		String fileType=getUploadFileContentType();
		for(String type:types){
			if(type.equals(fileType)){
				return null;
			}
		}
		return ERROR;
	}
	public long getPopedom() {
		return popedom;
	}
	public void setPopedom(long popedom) {
		this.popedom = popedom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFilename() {
		
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getDownloadFile() {
		return downloadFile;
	}
	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getAllowTypes() {
		return allowTypes;
	}
	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
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
	
	public User getLoginuser() {
		return loginuser;
	}
	public void setLoginuser(User loginuser) {
		this.loginuser = loginuser;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public long getIntegral() {
		return integral;
	}

	public void setIntegral(long integral) {
		this.integral = integral;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
}
