package calito.bot.entities;

import javax.persistence.*;

@Entity
@Table(name="TIMESPAN_DETAILS")
@NamedQueries({
	@NamedQuery(name="TimeSpan.findAll", query="SELECT t FROM TimeSpan t WHERE t.end = null")
})
public class TimeSpan {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TIMESPAN_ID")
	private Long id;
	
	@Column(name="TIMESPAN_START")
	private Long start;
	
	@Column(name="TIMESPAN_END")
	private Long end;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="WALLET_ID")
	private Wallet wallet;

	public TimeSpan() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	

}
