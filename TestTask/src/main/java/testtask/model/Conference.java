package testtask.model;

public class Conference {

	private long id;

	private String conferencename;

	private String conferencedatetime;

	private int conferenceroomid;

	private String conferroomname;

	private String conferroomlocation;

	private int freeseats;

	public Conference() {
		id = 0;
	}

	public Conference(long id, String conferenceName, String conferenceDateTime, int conferenceroomid,
			String conferroomname, String conferroomlocation, int freeseats) {
		this.id = id;
		this.conferencename = conferenceName;
		this.conferencedatetime = conferenceDateTime;
		this.conferenceroomid = conferenceroomid;
		this.conferroomname = conferroomname;
		this.conferroomlocation = conferroomlocation;
		this.freeseats = freeseats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConferenceName() {
		return conferencename;
	}

	public void setConferenceName(String conferenceName) {
		this.conferencename = conferenceName;
	}

	public String getConferenceDateTime() {
		return conferencedatetime;
	}

	public void setConferenceDateTime(String conferenceDateTime) {
		this.conferencedatetime = conferenceDateTime;
	}

	public int getConferenceroomid() {
		return conferenceroomid;
	}

	public void setConferenceroomid(int conferenceroomid) {
		this.conferenceroomid = conferenceroomid;
	}

	public String getConferroomname() {
		return conferroomname;
	}

	public void setConferroomname(String conferroomname) {
		this.conferroomname = conferroomname;
	}

	public String getConferroomlocation() {
		return conferroomlocation;
	}

	public void setConferroomlocation(String conferroomlocation) {
		this.conferroomlocation = conferroomlocation;
	}

	public int getFreeseats() {
		return freeseats;
	}

	public void setFreeseats(int freeseats) {
		this.freeseats = freeseats;
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
		if (!(obj instanceof Conference))
			return false;
		Conference other = (Conference) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conference [id=" + id + ", conferencename=" + conferencename + ", conferencedatetime="
				+ conferencedatetime + ", conferenceroomid=" + conferenceroomid + ", conferroomname=" + conferroomname
				+ ", conferroomlocation=" + conferroomlocation + ", freeseats=" + freeseats + "]";
	}

}
