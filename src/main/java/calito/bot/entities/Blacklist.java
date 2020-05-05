package calito.bot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BLACKLIST_DETAILS")
@NamedQueries({
	@NamedQuery(name="Blacklist.findAll", query="SELECT b FROM Blacklist b"),
	@NamedQuery(name="Blacklist.findByName", query="SELECT b FROM Blacklist b WHERE b.name = :name")
})
public class Blacklist {

	@Id
	@Column(name="BLACKLIST_USER_NAME", length=64)
	private String name;
	
	@Column(name="BLACKLIST_INFO", length=1000)
	private String info;

	@Column(name="BLACKLIST_DATE")
	private Date date;

	public Blacklist() {	}

	public Blacklist(String name, String info, Date date) {
		this.name = name;
		this.info = info;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}




	
}
