package testtask.model;

public class ConferenceRoom {

	private long id;

	private String conferenceroomname;

	private String conferenceroomlocation;

	private int conferenceroomseats;

	public ConferenceRoom() {
		id = 0;
	}

	public ConferenceRoom(long id, String conferenceroomname, String conferenceroomlocation, int conferenceroomseats) {
		this.id = id;
		this.conferenceroomname = conferenceroomname;
		this.conferenceroomlocation = conferenceroomlocation;
		this.conferenceroomseats = conferenceroomseats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConferenceRoomName() {
		return conferenceroomname;
	}

	public void setConferenceRoomName(String conferenceroomname) {
		this.conferenceroomname = conferenceroomname;
	}

	public String getConferenceRoomLocation() {
		return conferenceroomlocation;
	}

	public void setConferenceRoomLocation(String conferenceroomlocation) {
		this.conferenceroomlocation = conferenceroomlocation;
	}

	public int getConferenceroomseats() {
		return conferenceroomseats;
	}

	public void setConferenceroomseats(int conferenceroomseats) {
		this.conferenceroomseats = conferenceroomseats;
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
		if (!(obj instanceof ConferenceRoom))
			return false;
		ConferenceRoom other = (ConferenceRoom) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConferenceRoom [id=" + id + ", conferencename=" + conferenceroomname + ", conferencedatetime="
				+ conferenceroomlocation + ", conferenceroomseats=" + conferenceroomseats + "]";
	}

}
