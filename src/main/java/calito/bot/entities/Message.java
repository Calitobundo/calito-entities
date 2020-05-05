package calito.bot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MESSAGE_DETAILS")
@NamedQueries({
	@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m"),
	@NamedQuery(name="Message.findById", query="SELECT m FROM Message m WHERE m.id = :id")
})
public class Message {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MESSAGE_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="MESSAGE_USER")
	private User user;
	
	@Column(name="MESSAGE_TEXT", length=1000)
	private String text;

	@Column(name="MESSAGE_DATE_CREATED")
	private Date dateCreated;

	public Message() {	}

	public Message(User user, String text, Date dateCreated) {
		this.user = user;
		this.text = text;
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	
}
