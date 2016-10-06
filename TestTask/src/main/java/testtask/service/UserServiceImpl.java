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
import testtask.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	public User getParticipantDb(long id) throws Exception {
		Connection conn = dbConnector();

		User user = null;

		Statement st = conn.createStatement();

		String query = "SELECT * from Participant";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					String fullname = rs.getString(2);
					String birthdate = rs.getString(3);
					int conferenceid = rs.getInt(4);
					user = new User(id, fullname, birthdate, conferenceid, "", "");

				}
			}

		} finally {
			rs.close();
		}

		return user;
	}

	private Connection dbConnector() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		Connection conn = connector.createDbCon();
		return conn;
	}

	public List<User> getParticipantsDb() throws ClassNotFoundException, SQLException {
		Connection conn = dbConnector();

		List<User> users = new ArrayList<User>();
		Statement st = conn.createStatement();

		st.executeUpdate(
				"CREATE table if not exists Participant (ID INTEGER PRIMARY KEY AUTOINCREMENT, fullname varchar(150), birthdate datetime, conferenceid integer)");

		String query = "SELECT Participant.ID, Participant.fullname, Participant.birthdate, Conference.ID, Conference.name, Conference.conferencetime "
				+ "from Participant JOIN Conference ON Participant.conferenceid = Conference.ID JOIN Conferenceroom ON Conference.conferenceroomid = Conferenceroom.ID";

		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String fullname = rs.getString(2);
				String birthdate = rs.getString(3);
				int conferenceid = rs.getInt(4);
				String name = rs.getString(5);
				String conferencetime = rs.getString(6);

				users.add(new User(id, fullname, birthdate, conferenceid, name, conferencetime));

			}

		} finally {
			rs.close();
		}

		return users;
	}

	public void saveParticipantDb(String fullname, String birthdate, int conferenceid) throws Exception {
		Connection conn = dbConnector();

		Statement st = conn.createStatement();

		st.executeUpdate(
				"CREATE table if not exists Participant (ID INTEGER PRIMARY KEY AUTOINCREMENT, fullname varchar(150), birthdate datetime, conferenceid integer)");

		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO Participant (fullname, birthdate, conferenceid) VALUES (?, ?, ?)");
		ps.setString(1, fullname);
		ps.setString(2, birthdate);
		ps.setInt(3, conferenceid);
		ps.execute();

	}

	public void updateParticipantDb(long id, String fullname, String birthdate, int conferenceid) throws Exception {
		Connection conn = dbConnector();

		PreparedStatement ps = conn
				.prepareStatement("UPDATE Participant SET fullname = ?,  birthdate = ?, conferenceid = ? where id = ?");
		ps.setString(1, fullname);
		ps.setString(2, birthdate);
		ps.setInt(3, conferenceid);
		ps.setInt(4, (int) id);

		ps.execute();

	}

	public void deleteParticipantDb(long id) throws Exception {
		Connection conn = dbConnector();

		PreparedStatement ps = conn.prepareStatement("DELETE FROM Participant where id = ?");

		ps.setInt(1, (int) id);

		ps.execute();

	}

}
