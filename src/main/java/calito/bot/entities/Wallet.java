package calito.bot.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="WALLET_DETAILS")
public class Wallet {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WALLET_ID")
	private Long id;

	@Column(name="WALLET_BALANCE")
	private Long balance;

	@Column(name="WALLET_VALID")
	private boolean valid;

	@OneToMany(mappedBy="wallet", cascade=CascadeType.ALL)
	private Set<TimeSpan> timeSpans = new HashSet<>(0);

	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "USER_ID")
	private User user;

	public Wallet() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getBalance() {
		return balance;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Set<TimeSpan> getTimeSpans() {
		return timeSpans;
	}

	public void setTimeSpans(Set<TimeSpan> timeSpans) {
		this.timeSpans = timeSpans;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 
	 * 
	 * 
	 */

	public void addBalance(Long balance) {
		this.balance += balance;
	}

	public void removeBalance(Long balance) {
		this.balance -= balance;
	}
	
	
	
	
	
}
