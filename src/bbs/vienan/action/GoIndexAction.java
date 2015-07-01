package bbs.vienan.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.SubItem;
import bbs.vienan.biz.ItemBiz;
import bbs.vienan.biz.SubItemBiz;
import bbs.vienan.biz.TopicBiz;
import bbs.vienan.biz.impl.ItemBizImpl;
import bbs.vienan.biz.impl.SubItemBizImpl;
import bbs.vienan.biz.impl.TopicBizImpl;

public class GoIndexAction extends ActionSupport{
	//鏍忕洰
	private ItemBiz itemBiz=new ItemBizImpl();
	private List<Item> items=new ArrayList();
	//瀛愭爮鐩�
	private SubItemBiz subItemBiz=new SubItemBizImpl();
	private List<SubItem> subItems=new ArrayList();
	//甯栧瓙淇℃伅
	private Map<Item,List> map=new HashMap<Item, List>();
	ActionContext ac=ActionContext.getContext();
	public String execute(){
		System.out.println("gonIdnex方法");
		items=itemBiz.findAllItem();
		for(Item item:items){
			subItems=subItemBiz.findAllSub(item.getItemid());
			map.put(item, subItems);
		}
		System.out.println("map"+map);
		return SUCCESS;
	}

	public ItemBiz getItemBiz() {
		return itemBiz;
	}

	public void setItemBiz(ItemBiz itemBiz) {
		this.itemBiz = itemBiz;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public SubItemBiz getSubItemBiz() {
		return subItemBiz;
	}

	public void setSubItemBiz(SubItemBiz subItemBiz) {
		this.subItemBiz = subItemBiz;
	}

	public List<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItem> subItems) {
		this.subItems = subItems;
	}

	public Map<Item, List> getMap() {
		return map;
	}

	public void setMap(Map<Item, List> map) {
		this.map = map;
	}
	
}
