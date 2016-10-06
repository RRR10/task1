package testtask.service;

import java.sql.SQLException;
import java.util.List;

import testtask.model.User;

public interface UserService {

	public User getParticipantDb(long id) throws Exception;

	public List<User> getParticipantsDb() throws ClassNotFoundException, SQLException;

	public void saveParticipantDb(String fullname, String birthdate, int conferenceid) throws Exception;

	public void updateParticipantDb(long id, String fullname, String birthdate, int conferenceid) throws Exception;

	public void deleteParticipantDb(long id) throws Exception;

}
