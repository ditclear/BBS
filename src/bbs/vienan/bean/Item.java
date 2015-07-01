package bbs.vienan.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ITEM", schema = "SYSTEM")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Item implements java.io.Serializable {

	// Fields

	private Long itemid;
	private String itemname;
	private String itemdescription;
	private Long manager;
	private String username;
	private Set<SubItem> subitems = new HashSet<SubItem>(0);

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String itemname, Long manager) {
		this.itemname = itemname;
		this.manager = manager;
	}
	
	
	public Item(Long itemid) {
		super();
		this.itemid = itemid;
	}

	/** full constructor */
	public Item(String itemname, String itemdescription, Long manager,
			Set<SubItem> subitems) {
		this.itemname = itemname;
		this.itemdescription = itemdescription;
		this.manager = manager;
		this.subitems = subitems;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="itemsid")
	@SequenceGenerator(name="itemsid",sequenceName="itemsid",allocationSize=1,initialValue=0)
	@Column(name = "ITEMID", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	@Column(name = "ITEMNAME", nullable = false, length = 20)
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Column(name = "ITEMDESCRIPTION", length = 100)
	public String getItemdescription() {
		return this.itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	@Column(name = "MANAGER", nullable = false, precision = 11, scale = 0)
	public Long getManager() {
		return this.manager;
	}

	public void setManager(Long manager) {
		this.manager = manager;
	}
	@Formula(value="(SELECT u.username from users u where u.userid=manager)")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
	public Set<SubItem> getSubitems() {
		return this.subitems;
	}

	public void setSubitems(Set<SubItem> subitems) {
		this.subitems = subitems;
	}

}