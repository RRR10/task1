package testtask.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import testtask.configuration.DbConnector;
import testtask.model.ConferenceRoom;

@Service("conferenceRoomService")
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

	public ConferenceRoom getConferenceRoomDb(long id) throws Exception {

		Connection conn = dbConnector();

		ConferenceRoom conferenceroom = null;

		Statement st = conn.createStatement();

		String query = "SELECT * from Conferenceroom";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					String conferenceroomname = rs.getString(2);
					String conferenceroomlocation = rs.getString(3);
					int conferenceroomseats = rs.getInt(4);
					conferenceroom = new ConferenceRoom(id, conferenceroomname, conferenceroomlocation,
							conferenceroomseats);

				}
			}

		} finally {
			rs.close();
		}

		return conferenceroom;
	}

	private Connection dbConnector() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		Connection conn = connector.createDbCon();
		return conn;
	}

	public List<ConferenceRoom> getConferenceRoomsDb() throws ClassNotFoundException, SQLException {
		Connection conn = dbConnector();

		List<ConferenceRoom> conferencerooms = new ArrayList<ConferenceRoom>();
		Statement st = conn.createStatement();

		st.executeUpdate(
				"CREATE table if not exists Conferenceroom (ID INTEGER PRIMARY KEY AUTOINCREMENT, conferenceroomname varchar(150), conferenceroomlocation varchar(150), conferenceroomseats integer)");

		String query = "SELECT * from Conferenceroom";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String conferenceroomname = rs.getString(2);
				String conferenceroomlocation = rs.getString(3);
				int conferenceroomseats = rs.getInt(4);
				conferencerooms
						.add(new ConferenceRoom(id, conferenceroomname, conferenceroomlocation, conferenceroomseats));

			}

		} finally {
			rs.close();
		}

		return conferencerooms;
	}

	public void saveConferenceRoomDb(String conferenceroomname, String conferenceroomlocation, int conferenceroomseats)
			throws Exception {
		Connection conn = dbConnector();

		Statement st = conn.createStatement();
		st.executeUpdate(
				"CREATE table if not exists Conferenceroom (ID INTEGER PRIMARY KEY AUTOINCREMENT, conferenceroomname varchar(150), conferenceroomlocation varchar(150), conferenceroomseats integer)");

		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO Conferenceroom (conferenceroomname, conferenceroomlocation, conferenceroomseats) VALUES (?, ?, ?)");
		ps.setString(1, conferenceroomname);
		ps.setString(2, conferenceroomlocation);
		ps.setInt(3, conferenceroomseats);
		ps.execute();

	}

	public void updateConferenceRoomDb(long id, String conferenceroomname, String conferenceroomlocation,
			int conferenceroomseats) throws Exception {
		Connection conn = dbConnector();

		PreparedStatement ps = conn.prepareStatement(
				"UPDATE Conferenceroom SET conferenceroomname = ?,  conferenceroomlocation = ?,  conferenceroomseats = ?  where id = ?");
		ps.setString(1, conferenceroomname);
		ps.setString(2, conferenceroomlocation);
		ps.setInt(3, conferenceroomseats);
		ps.setInt(4, (int) id);

		ps.execute();

	}

	public void deleteConferenceRoomDb(long id) throws Exception {
		Connection conn = dbConnector();

		PreparedStatement ps = conn.prepareStatement("DELETE FROM Conferenceroom where id = ?");

		ps.setInt(1, (int) id);

		ps.execute();

	}

}
