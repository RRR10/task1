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
import testtask.model.Conference;

@Service("conferenceService")
public class ConferenceServiceImpl implements ConferenceService {

	public Conference getConferenceDb(long id) throws ClassNotFoundException, SQLException {

		Connection conn = dbConnector();

		Conference conference = null;

		Statement st = conn.createStatement();

		String query = "SELECT * from Conference";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					String name = rs.getString(2);
					String conferencetime = rs.getString(3);
					int conferenceroomid = rs.getInt(4);
					conference = new Conference(id, name, conferencetime, conferenceroomid, "", "", 0);

				}
			}

		} finally {
			rs.close();
		}

		return conference;
	}

	private Connection dbConnector() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		Connection conn = connector.createDbCon();
		return conn;
	}

	public List<Conference> getConferencesDb() throws ClassNotFoundException, SQLException {
		Connection conn = dbConnector();

		List<Conference> conferences = new ArrayList<Conference>();
		Statement st = conn.createStatement();

		st.executeUpdate(
				"CREATE table if not exists Conference (ID INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(150), conferencetime datetime, conferenceroomid integer)");

		String query = "SELECT Conference.ID, Conference.name, Conference.conferencetime, Conference.conferenceroomid, Conferenceroom.conferenceroomname, Conferenceroom.conferenceroomlocation, case when Participant.ID is null then Conferenceroom.conferenceroomseats else Conferenceroom.conferenceroomseats - count(*) end "
				+ "from Conference INNER JOIN Conferenceroom ON Conference.conferenceroomid = Conferenceroom.ID "
				+ "LEFT JOIN Participant ON Conference.ID = Participant.conferenceid "
				+ "GROUP BY Conference.ID, Conferenceroom.conferenceroomseats";

		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String conferencetime = rs.getString(3);
				int conferenceroomid = rs.getInt(4);
				String conferenceroomname = rs.getString(5);
				String conferenceroomlocation = rs.getString(6);
				int freeseats = rs.getInt(7);
				conferences.add(new Conference(id, name, conferencetime, conferenceroomid, conferenceroomname,
						conferenceroomlocation, freeseats));

			}

		} finally {
			rs.close();
		}

		return conferences;
	}

	public void saveConferenceDb(String name, String conferencetime, int conferenceroomid) throws Exception {
		Connection conn = dbConnector();

		Statement st = conn.createStatement();
		st.executeUpdate(
				"CREATE table if not exists Conference (ID INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(150), conferencetime datetime, conferenceroomid integer)");

		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO Conference (name, conferencetime, conferenceroomid) VALUES (?, ?, ?)");
		ps.setString(1, name);
		ps.setString(2, conferencetime);
		ps.setInt(3, conferenceroomid);

		ps.execute();

	}

	public void updateConferenceDb(long id, String name, String conferencetime, int conferenceroomid) throws Exception {
		Connection conn = dbConnector();

		PreparedStatement ps = conn.prepareStatement(
				"UPDATE Conference SET name = ?,  conferencetime = ?, conferenceroomid = ? where id = ?");
		ps.setString(1, name);
		ps.setString(2, conferencetime);
		ps.setInt(3, conferenceroomid);
		ps.setInt(4, (int) id);

		ps.execute();

	}

	public void deleteConferenceDb(long id) throws Exception {
		Connection conn = dbConnector();

		PreparedStatement ps = conn.prepareStatement("DELETE FROM Conference where id = ?");

		ps.setInt(1, (int) id);

		ps.execute();

	}

}
