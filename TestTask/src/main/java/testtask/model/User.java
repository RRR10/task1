package testtask.model;

public class User {

	private long id;

	private String username;

	private String birthdate;

	private int conferenceid;

	private String confername;

	private String confertime;

	public User() {
		id = 0;
	}

	public User(long id, String username, String birthdate, int conferenceid, String confername, String confertime) {
		this.id = id;
		this.username = username;
		this.birthdate = birthdate;
		this.conferenceid = conferenceid;
		this.confername = confername;
		this.confertime = confertime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getConferenceid() {
		return conferenceid;
	}

	public void setConferenceid(int conferenceid) {
		this.conferenceid = conferenceid;
	}

	public String getConfername() {
		return confername;
	}

	public void setConfername(String confername) {
		this.confername = confername;
	}

	public String getConfertime() {
		return confertime;
	}

	public void setConfertime(String confertime) {
		this.confertime = confertime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthdate=" + birthdate + ", conferenceid="
				+ conferenceid + ", confername=" + confername + ", confertime=" + confertime + "]";
	}

}
