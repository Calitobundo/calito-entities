package calito.bot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USER_DETAILS")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.id = :id"),
	@NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE u.name = :name"),
	@NamedQuery(name="User.findByBlacklisted", query="SELECT u FROM User u WHERE u.blacklisted = :blacklisted")
})
public class User {

	@Id
	@Column(name="USER_ID")
	private String id;

	@Column(name="USER_NAME")
	private String name;

	@Column(name="USER_DATE_CREATED")
	private Date dateCreated;

	@Column(name="USER_MINEABLE")
	private boolean mineable = true;

	@Column(name="USER_BLACKLISTED")
	private boolean blacklisted = false;

	@Column(name="USER_VISIBLE")
	private boolean visible = true;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", optional = false)	
	private Wallet wallet;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	private Set<Message> messages = new HashSet<>(0);

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="sender")
	private Set<Transfer> transfersSended = new HashSet<>(0);

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="receiver")
	private Set<Transfer> transfersReceived = new HashSet<>(0);

	public User() {	}

	public User(String id, String name, Date dateCreated) {
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<Transfer> getTransfersSended() {
		return transfersSended;
	}

	public void setTransfersSended(Set<Transfer> transfersSended) {
		this.transfersSended = transfersSended;
	}

	public Set<Transfer> getTransfersReceived() {
		return transfersReceived;
	}

	public void setTransfersReceived(Set<Transfer> transfersReceived) {
		this.transfersReceived = transfersReceived;
	}

	public boolean isMineable() {
		return mineable;
	}

	public void setMineable(boolean mineable) {
		this.mineable = mineable;
	}

	public boolean isBlacklisted() {
		return blacklisted;
	}

	public void setBlacklisted(boolean blacklisted) {
		this.blacklisted = blacklisted;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}



	
	
}
