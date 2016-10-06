package testtask;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredTest {
	
	@Test
	public void makeSureThatTesttaskIsUp(){
		given().when().get("http://localhost:8080/testtask/").then().statusCode(200);
	}
	
	//need test databases
	/*@Test
    public void saveConferenceRoom() {
        Map<String,String> conferenceroom = new HashMap<>();
        conferenceroom.put("conferenceRoomLocation", "M/S Baltic Queen2");
        conferenceroom.put("conferenceRoomName", "M/S Baltic Queen conference2");
        conferenceroom.put("conferenceroomseats", "100");
        conferenceroom.put("id", null);
        given()
        .contentType("application/json")
        .body(conferenceroom)
        .when().post("http://localhost:8080/testtask/conferenceroom/").then()
        .statusCode(201);
    }*/
	
	@Test
    public void updateConferenceRoom() {
        Map<String,String> conferenceroom = new HashMap<>();
        conferenceroom.put("conferenceRoomLocation", "M/S Baltic Queen");
        conferenceroom.put("conferenceRoomName", "M/S Baltic Queen conference");
        conferenceroom.put("conferenceroomseats", "124");
        conferenceroom.put("id", "23");
        given()
        .contentType("application/json")
        .body(conferenceroom)
        .when().put("http://localhost:8080/testtask/conferenceroom/23").then()
        .statusCode(200);
    }
	
	//need test databases
	/*@Test
    public void deleteConferenceRoom() {
		given().when().delete("http://localhost:8080/testtask/conferenceroom/23").then().statusCode(204);
    }*/
	

	//need test databases
	/*@Test
    public void saveConference() {
        Map<String,String> conference = new HashMap<>();
        conference.put("conferenceDateTime", "20.10.2016 17:00");
        conference.put("conferenceName", "Big Conference 2017");
        conference.put("conferenceroomid", "9");
        conference.put("conferroomlocation", "");
        conference.put("conferroomname", "");
        conference.put("freeseats", "");
        conference.put("id", null);
        given()
        .contentType("application/json")
        .body(conference)
        .when().post("http://localhost:8080/testtask/conference/").then()
        .statusCode(201);
      
    }*/
	
	@Test
    public void updateConference() {
        Map<String,String> conferenceroom = new HashMap<>();
        conferenceroom.put("conferenceDateTime", "08.10.2016 17:00");
        conferenceroom.put("conferenceName", "October 2016 General Conference");
        conferenceroom.put("conferenceroomid", "23");
        conferenceroom.put("conferroomlocation", "");
        conferenceroom.put("conferroomname", "");
        conferenceroom.put("freeseats", "");
        conferenceroom.put("id", "24");
        given()
        .contentType("application/json")
        .body(conferenceroom)
        .when().put("http://localhost:8080/testtask/conference/24").then()
        .statusCode(200);
    }
	
	//need test databases
	/*@Test
    public void deleteConference() {
		given().when().delete("http://localhost:8080/testtask/conference/18").then().statusCode(204);
    }*/
	
	//need test databases
	/*@Test
    public void saveUser() {
        Map<String,String> user = new HashMap<>();
        user.put("birthdate", "20.10.2000");
        user.put("conferenceid", "18");
        user.put("confername", "");
        user.put("confertime", "");
        user.put("id", null);
        user.put("username", "Ivan Petrov");
        given()
        .contentType("application/json")
        .body(user)
        .when().post("http://localhost:8080/testtask/user/").then()
        .statusCode(201);
        
    }*/
	
	@Test
    public void updateUser() {
        Map<String,String> user = new HashMap<>();
        user.put("birthdate", "20.10.2000");
        user.put("conferenceid", "24");
        user.put("confername", "");
        user.put("confertime", "");
        user.put("id", "31");
        user.put("username", "Ivan Petrov");
        given()
        .contentType("application/json")
        .body(user)
        .when().put("http://localhost:8080/testtask/user/31").then()
        .statusCode(200);
    }
	
	//need test databases
	/*@Test
    public void deleteUser() {
		given().when().delete("http://localhost:8080/testtask/user/31").then().statusCode(204);
    }*/
}
