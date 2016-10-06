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

import testtask.model.ConferenceRoom;
import testtask.service.ConferenceRoomService;

@RestController
public class ConferenceRoomRestController {

	@Autowired
	ConferenceRoomService conferenceRoomService;

	// Retrieve All Conferences

	@RequestMapping(value = "/conferenceroom/", method = RequestMethod.GET)
	public ResponseEntity<List<ConferenceRoom>> listAllConferenceRooms() throws ClassNotFoundException, SQLException {
		List<ConferenceRoom> conferences = conferenceRoomService.getConferenceRoomsDb();
		if (conferences.isEmpty()) {
			return new ResponseEntity<List<ConferenceRoom>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ConferenceRoom>>(conferences, HttpStatus.OK);
	}

	// Retrieve Single ConferenceRoom

	@RequestMapping(value = "/conferenceroom/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConferenceRoom> getConferenceRoom(@PathVariable("id") long id) throws Exception {
		ConferenceRoom conferenceroom = conferenceRoomService.getConferenceRoomDb(id);
		if (conferenceroom == null) {
			return new ResponseEntity<ConferenceRoom>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ConferenceRoom>(conferenceroom, HttpStatus.OK);
	}

	// Create a ConferenceRoom

	@RequestMapping(value = "/conferenceroom/", method = RequestMethod.POST)
	public ResponseEntity<Void> createConferenceRoom(@RequestBody ConferenceRoom conferenceroom,
			UriComponentsBuilder ucBuilder) throws Exception {

		conferenceRoomService.saveConferenceRoomDb(conferenceroom.getConferenceRoomName(),
				conferenceroom.getConferenceRoomLocation(), conferenceroom.getConferenceroomseats());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/conferenceroom/{id}").buildAndExpand(conferenceroom.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update a ConferenceRoom

	@RequestMapping(value = "/conferenceroom/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ConferenceRoom> updateConferenceRoom(@PathVariable("id") long id,
			@RequestBody ConferenceRoom conferenceroom) throws Exception {

		ConferenceRoom currentConferenceroom = conferenceRoomService.getConferenceRoomDb(id);

		if (currentConferenceroom == null) {
			return new ResponseEntity<ConferenceRoom>(HttpStatus.NOT_FOUND);
		}

		currentConferenceroom.setConferenceRoomName(conferenceroom.getConferenceRoomName());
		currentConferenceroom.setConferenceRoomLocation(conferenceroom.getConferenceRoomLocation());
		currentConferenceroom.setConferenceroomseats(conferenceroom.getConferenceroomseats());
		conferenceRoomService.updateConferenceRoomDb(id, currentConferenceroom.getConferenceRoomName(),
				currentConferenceroom.getConferenceRoomLocation(), currentConferenceroom.getConferenceroomseats());

		return new ResponseEntity<ConferenceRoom>(currentConferenceroom, HttpStatus.OK);
	}

	// Delete a ConferenceRoom

	@RequestMapping(value = "/conferenceroom/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ConferenceRoom> deleteConferenceRoom(@PathVariable("id") long id) throws Exception {

		ConferenceRoom conference = conferenceRoomService.getConferenceRoomDb(id);
		if (conference == null) {
			return new ResponseEntity<ConferenceRoom>(HttpStatus.NOT_FOUND);
		}
		conferenceRoomService.deleteConferenceRoomDb(id);
		return new ResponseEntity<ConferenceRoom>(HttpStatus.NO_CONTENT);
	}

}