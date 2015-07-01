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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

/**
 * Subitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUBITEM", schema = "SYSTEM")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class SubItem implements java.io.Serializable {

	// Fields

	private Long subitemid;
	private Item item;
	private String subitemname;
	private String itemdescription;
	private Long topicid;
	private Long manager;
	private String username;
	private Set<Topic> topics = new HashSet<Topic>(0);

	// Constructors

	/** default constructor */
	public SubItem() {
	}

	/** minimal constructor */
	public SubItem(String subitemname, Long manager) {
		this.subitemname = subitemname;
		this.manager = manager;
	}

	/** full constructor */
	public SubItem(Item item, String subitemname, String itemdescription,
			Long topicid, Long manager, Set<Topic> topics) {
		this.item = item;
		this.subitemname = subitemname;
		this.itemdescription = itemdescription;
		this.topicid = topicid;
		this.manager = manager;
		this.topics = topics;
	}

	
	public SubItem(Long subitemid) {
		super();
		this.subitemid = subitemid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="subitemsid")
	@SequenceGenerator(name="subitemsid",sequenceName="subitemsid",allocationSize=1,initialValue=0)
	@Column(name = "SUBITEMID", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getSubitemid() {
		return this.subitemid;
	}

	public void setSubitemid(Long subitemid) {
		this.subitemid = subitemid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEMID")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "SUBITEMNAME", nullable = false, length = 20)
	public String getSubitemname() {
		return this.subitemname;
	}

	public void setSubitemname(String subitemname) {
		this.subitemname = subitemname;
	}

	@Column(name = "ITEMDESCRIPTION", length = 100)
	public String getItemdescription() {
		return this.itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	@Column(name = "TOPICID", precision = 11, scale = 0)
	public Long getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "subitem")
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}