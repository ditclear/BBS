package bbs.vienan.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;

public class UserHobbyAction {
	private String[] hobby = {"足球","阅读","音乐"};
	public String execute()
	{
	return Action.SUCCESS;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
}
