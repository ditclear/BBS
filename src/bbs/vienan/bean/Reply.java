package bbs.vienan.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Reply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REPLY", schema = "SYSTEM")
public class Reply implements java.io.Serializable {

	// Fields

	private Long id;
	private Topic topic;
	private User users;
	private String content;
	private Date replydate;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(Topic topic, User users, String content) {
		this.topic = topic;
		this.users = users;
		this.content = content;
	}

	/** full constructor */
	public Reply(Topic topic, User users, String content, Date replydate) {
		this.topic = topic;
		this.users = users;
		this.content = content;
		this.replydate = replydate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="replysid")
	@SequenceGenerator(name="replysid",sequenceName="replysid",allocationSize=1,initialValue=0)
	@Column(name = "ID", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOPICID", nullable = false)
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", nullable = false)
	public User getUsers() {
		return this.users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Column(name = "CONTENT", nullable = false, length = 2000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REPLYDATE", length = 7)
	public Date getReplydate() {
		return this.replydate;
	}

	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}

}