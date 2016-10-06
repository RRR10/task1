package testtask.service;

import java.sql.SQLException;
import java.util.List;

import testtask.model.ConferenceRoom;

public interface ConferenceRoomService {

	public ConferenceRoom getConferenceRoomDb(long id) throws Exception;

	public List<ConferenceRoom> getConferenceRoomsDb() throws ClassNotFoundException, SQLException;

	public void saveConferenceRoomDb(String conferenceroomname, String conferenceroomlocation, int conferenceroomseats)
			throws Exception;

	public void updateConferenceRoomDb(long id, String conferenceroomname, String conferenceroomlocation,
			int conferenceroomseats) throws Exception;

	public void deleteConferenceRoomDb(long id) throws Exception;
}
