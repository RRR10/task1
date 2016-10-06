package testtask.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import testtask.model.Conference;
import testtask.service.ConferenceService;

@RestController
public class ConferenceRestController {

	@Autowired
	ConferenceService conferenceService;

	// Retrieve All Conferences

	@RequestMapping(value = "/conference/", method = RequestMethod.GET)
	public ResponseEntity<List<Conference>> listAllConferences() throws ClassNotFoundException, SQLException {
		List<Conference> conferences = conferenceService.getConferencesDb();
		if (conferences.isEmpty()) {
			return new ResponseEntity<List<Conference>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Conference>>(conferences, HttpStatus.OK);
	}

	// Retrieve Single Conference

	@RequestMapping(value = "/conference/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conference> getConference(@PathVariable("id") long id) throws Exception {
		Conference conference = conferenceService.getConferenceDb(id);
		if (conference == null) {
			return new ResponseEntity<Conference>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conference>(conference, HttpStatus.OK);
	}

	// Create a Conference

	@RequestMapping(value = "/conference/", method = RequestMethod.POST)
	public ResponseEntity<Void> createConference(@RequestBody Conference conference, UriComponentsBuilder ucBuilder)
			throws Exception {

		conferenceService.saveConferenceDb(conference.getConferenceName(), conference.getConferenceDateTime(),
				conference.getConferenceroomid());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/conference/{id}").buildAndExpand(conference.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update a Conference

	@RequestMapping(value = "/conference/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Conference> updateConference(@PathVariable("id") long id, @RequestBody Conference conference)
			throws Exception {

		Conference currentConference = conferenceService.getConferenceDb(id);

		if (currentConference == null) {
			return new ResponseEntity<Conference>(HttpStatus.NOT_FOUND);
		}

		currentConference.setConferenceName(conference.getConferenceName());
		currentConference.setConferenceDateTime(conference.getConferenceDateTime());
		currentConference.setConferenceroomid(conference.getConferenceroomid());
		conferenceService.updateConferenceDb(id, currentConference.getConferenceName(),
				currentConference.getConferenceDateTime(), currentConference.getConferenceroomid());
		return new ResponseEntity<Conference>(currentConference, HttpStatus.OK);
	}

	// Delete a Conference

	@RequestMapping(value = "/conference/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Conference> deleteConference(@PathVariable("id") long id) throws Exception {

		Conference conference = conferenceService.getConferenceDb(id);
		if (conference == null) {
			return new ResponseEntity<Conference>(HttpStatus.NOT_FOUND);
		}
		conferenceService.deleteConferenceDb(id);
		return new ResponseEntity<Conference>(HttpStatus.NO_CONTENT);
	}

}