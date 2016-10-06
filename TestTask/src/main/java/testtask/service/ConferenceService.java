package testtask.service;

import java.sql.SQLException;
import java.util.List;

import testtask.model.Conference;

public interface ConferenceService {

	public Conference getConferenceDb(long id) throws ClassNotFoundException, SQLException;

	public List<Conference> getConferencesDb() throws ClassNotFoundException, SQLException;

	public void saveConferenceDb(String name, String conferencetime, int conferenceroomid) throws Exception;

	public void updateConferenceDb(long id, String name, String conferencetime, int conferenceroomid) throws Exception;

	public void deleteConferenceDb(long id) throws Exception;
}
