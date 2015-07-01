package bbs.vienan.bean;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;


/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TOPIC", schema = "SYSTEM")
public class Topic implements java.io.Serializable {

	// Fields

	private Long topicid;
	private SubItem subitem;
	private User users;
	private String title;
	private String content;
	private Long replyid;
	private Date topicdate;
	private Long hasread;
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(SubItem subitem, User users, String title, String content,
			Date topicdate, Long hasread) {
		this.subitem = subitem;
		this.users = users;
		this.title = title;
		this.content = content;
		this.topicdate = topicdate;
		this.hasread = hasread;
	}

	/** full constructor */
	public Topic(SubItem subitem, User users, String title, String content,
			Long replyid, Date topicdate, Long hasread, Set<Reply> replies) {
		this.subitem = subitem;
		this.users = users;
		this.title = title;
		this.content = content;
		this.replyid = replyid;
		this.topicdate = topicdate;
		this.hasread = hasread;
		this.replies = replies;
	}

	
	public Topic(Long topicid) {
		super();
		this.topicid = topicid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="topicsid")
	@SequenceGenerator(name="topicsid",sequenceName="topicsid",allocationSize=1,initialValue=0)
	@Column(name = "TOPICID", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBITEMID", nullable = false)
	public SubItem getSubitem() {
		return this.subitem;
	}

	public void setSubitem(SubItem subitem) {
		this.subitem = subitem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", nullable = false)
	public User getUsers() {
		return this.users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Column(name = "TITLE", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "CONTENT", nullable = false, length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "REPLYID", precision = 11, scale = 0)
	public Long getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOPICDATE", nullable = false, length = 7)
	public Date getTopicdate() {
		return this.topicdate;
	}

	public void setTopicdate(Date topicdate) {
		this.topicdate = topicdate;
	}

	@Column(name = "HASREAD", nullable = false, precision = 11, scale = 0)
	public Long getHasread() {
		return this.hasread;
	}

	public void setHasread(Long hasread) {
		this.hasread = hasread;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "topic")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}