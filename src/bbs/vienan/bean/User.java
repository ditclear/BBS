package bbs.vienan.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USERS", schema = "SYSTEM")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class User implements java.io.Serializable {

	// Fields

	private Long userid;
	private String username;
	private String password;
	private String sex;
	private Long age;
	private Date birthday;
	private Long popedom;
	private Long integral;
	private String images;
	private Set<Topic> topics = new HashSet<Topic>(0);
	private Set<Reply> replies = new HashSet<Reply>(0);
	
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, Long popedom) {
		this.username = username;
		this.password = password;
		this.popedom = popedom;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public User(String username, String password, String sex, Long age,
			Date birthday, Long popedom, Long integral, String images,
			Set<Topic> topics, Set<Reply> replies) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.popedom = popedom;
		this.integral = integral;
		this.images = images;
		this.topics = topics;
		this.replies = replies;
	}

	public User(Long userid) {
		super();
		this.userid = userid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="usersid")
	@SequenceGenerator(name="usersid",sequenceName="usersid",allocationSize=1,initialValue=0)
	@Column(name = "USERID", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "USERNAME", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "SEX", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "AGE", precision = 11, scale = 0)
	@Formula(value="(SELECT TRUNC(months_between(sysdate, u.birthday)/12) from users u where u.userid=userid)")
	public Long getAge() {
		return this.age;
	}
	public void setAge(Long age) {
		this.age = age;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "POPEDOM", nullable = false, precision = 11, scale = 0)
	public Long getPopedom() {
		return this.popedom;
	}

	public void setPopedom(Long popedom) {
		this.popedom = popedom;
	}

	@Column(name = "INTEGRAL", precision = 11, scale = 0)
	public Long getIntegral() {
		return this.integral;
	}

	public void setIntegral(Long integral) {
		this.integral = integral;
	}

	@Column(name = "IMAGES", length = 20)
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}