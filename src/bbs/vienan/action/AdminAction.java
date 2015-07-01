package bbs.vienan.action;

import java.util.Date;
import java.util.List;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.Page;
import bbs.vienan.bean.SubItem;
import bbs.vienan.bean.User;
import bbs.vienan.biz.ItemBiz;
import bbs.vienan.biz.SubItemBiz;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.biz.impl.ItemBizImpl;
import bbs.vienan.biz.impl.SubItemBizImpl;
import bbs.vienan.biz.impl.UserBizImpl;
import bbs.vienan.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;


public class AdminAction extends ActionSupport{
	//user-attr
	private long userid;
	private String username;
	private String password;
	private String sex;
	private int age;
	private Date birthDay;
	private long popedom=1;
	private String images;
	//item_attr
	private long itemID;
	private String itemName;
	private String itemDescription;
	private Long manager;
	//subItem_attr
	private Long subItemID;
	private String subItemName;
	//Page
	private Page pageBean;
	private int curPage;
	//list
	private List<User> allUser;
	private UserBiz userBiz;
	private List<Item> items;
	private ItemBiz itemBiz;
	private List<SubItem> subItems;
	private SubItemBiz subItemBiz;
	//user
	public String addUser(){
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setPopedom(popedom);
		user.setIntegral(200L);
		user.setBirthday(birthDay);
		user.setImages(images);
		if(userBiz.cherlLongin(username)){
			addActionMessage("用户名已存在！");
			return "error";
		}
		if(userBiz.addUser(user)){
			addActionMessage("新增用户成功！");
			return "success";
		}else{
			addActionMessage("新增用户失败！");
			return "error";
		}
	}
	
	public String userDelete(){
		if(userBiz.deleteById(userid))
			return "success";
		else
			return "error";
	}
	
	public String findAllUser(){
		allUser=userBiz.findAllUser(popedom);
		return "success";
	}
	//item
	public String findAllItem(){
		items=itemBiz.findAllItem();
		this.pageBean=PageUtil.createPage(1,items.size(), curPage);
		items=itemBiz.queryByPage(pageBean);
		return "success";
	}
	public String itemAdd(){
		allUser=userBiz.findAllUser(2);
		if(itemName!=null){
		Item item=new Item();
		System.out.println("item:"+itemName+itemDescription+manager);
		item.setItemname(itemName);
		item.setItemdescription(itemDescription);
		item.setManager(manager);
		
		if(itemBiz.addItem(item)){
			addActionMessage("新增栏目成功！");
			return "success";
		}else{
			addActionMessage("新增栏目失败！");
			return "error";
		}
		}
		return "success";
	}
	public String itemDelete(){
		if(itemBiz.deleteById(itemID))
			return "success";
		return "error";
	}
	//subItem
	
	public String findAllSubItem(){
		items=itemBiz.findAllItem();
		System.out.println("itemID"+itemID);
		subItems=subItemBiz.findAllSub(itemID);
		return "success";
	}
	public String subItemAdd(){
		items=itemBiz.findAllItem();
		SubItem subItem=new SubItem();
		allUser=userBiz.findAllUser(3);
		if(subItemName!=null){
		System.out.println("subitem:"+subItemName+itemID+itemDescription);
		 subItem.setSubitemname(subItemName);
		 subItem.setItem(new Item(itemID));
		 subItem.setItemdescription(itemDescription);
		 subItem.setManager(manager);
		 
		if(subItemBiz.addSubItem(subItem)){
			addActionMessage("新增子栏目成功！");
			return "success";
		}else{
			addActionMessage("新增子栏目失败！");
			return "error";
		}
		}
		return "success";
	}
	public String subItemDelete(){
		if(subItemBiz.deleteById(subItemID))
			return "success";
		return "error";
	}
	
	public List<User> getAllUser() {
		return allUser;
	}
	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public long getPopedom() {
		return popedom;
	}
	public void setPopedom(long popedom) {
		this.popedom = popedom;
	}
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Long getManager() {
		return manager;
	}

	public void setManager(Long manager) {
		this.manager = manager;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public ItemBiz getItemBiz() {
		return itemBiz;
	}

	public void setItemBiz(ItemBiz itemBiz) {
		this.itemBiz = itemBiz;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	public Long getSubItemID() {
		return subItemID;
	}

	public void setSubItemID(Long subItemID) {
		this.subItemID = subItemID;
	}

	public String getSubItemName() {
		return subItemName;
	}

	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}

	public List<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItem> subItems) {
		this.subItems = subItems;
	}

	public SubItemBiz getSubItemBiz() {
		return subItemBiz;
	}

	public void setSubItemBiz(SubItemBiz subItemBiz) {
		this.subItemBiz = subItemBiz;
	}

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page pageBean) {
		this.pageBean = pageBean;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
}
