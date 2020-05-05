package calito.bot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TRANSFER_DETAILS")
@NamedQueries({
	@NamedQuery(name="Transfer.findAll", query="SELECT t FROM Transfer t"),
	@NamedQuery(name="Transfer.findByUser", query="SELECT t FROM Transfer t WHERE t.sender = :sender")
})
public class Transfer {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRANSFER_ID")
	private Long id;

	@Column(name="TRANSFER_AMOUNT")
	private Long amount;

	@Column(name="TRANSFER_DATE")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="TRANSFER_SENDER")
	private User sender;

	@ManyToOne
	@JoinColumn(name="TRANSFER_RECEIVER")
	private User receiver;

	public Transfer() {	}

	public Transfer(User sender, User receiver, Long amount) {
		this.amount = amount;
		this.date = new Date();
		this.sender = sender;
		this.receiver = receiver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}



	
	
}
