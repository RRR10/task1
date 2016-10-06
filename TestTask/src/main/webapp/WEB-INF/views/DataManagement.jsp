<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Test Task</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-maxlength {
          background-color: red;
      }
      .conferenceName.ng-valid {
          background-color: lightgreen;
      }
      .conferenceName.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .conferenceName.ng-dirty.ng-invalid-maxlength {
          background-color: red;
      }
     .conferenceroomname.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .conferenceroomname.ng-dirty.ng-invalid-maxlength {
          background-color: red;
      }
      .conferenceroomlocation.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .conferenceroomlocation.ng-dirty.ng-invalid-maxlength {
          background-color: red;
      }
      .conferenceroomseats.ng-dirty.ng-invalid-required {
          background-color: red;
      }
    </style>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     <link rel="stylesheet" href="<c:url value='/static/css/angularjs-datetime-picker.css' />" />
  </head>
  <body ng-app="myApp" class="ng-cloak">
        <div class="generic-container" ng-controller="ConferenceRoomController as crctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Conference Room Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="crctrl.submit()" name="crmyForm" class="form-horizontal">
                      <input type="hidden" ng-model="crctrl.conferenceroom.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference room name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="crctrl.conferenceroom.conferenceRoomName" name="crname" class="username form-control input-sm" placeholder="Enter conference room name" required maxlength="150" ng-maxlength="150"/>
                                  <div class="has-error" ng-show="crmyForm.$dirty">
                                      <span ng-show="crmyForm.crname.$error.required">This is a required field</span>
                                      <span ng-show="crmyForm.crname.$error.maxlength">Max length required is 150</span>
                                      <span ng-show="crmyForm.crname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference room location</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="crctrl.conferenceroom.conferenceRoomLocation" name="crlname" class="username form-control input-sm" placeholder="Enter conference room location" required maxlength="150" ng-maxlength="150"/>
                                  <div class="has-error" ng-show="crmyForm.$dirty">
                                      <span ng-show="crmyForm.crlname.$error.required">This is a required field</span>
                                      <span ng-show="crmyForm.crlname.$error.maxlength">Max length required is 150</span>
                                      <span ng-show="crmyForm.crlname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference room max seats</label>
                              <div class="col-md-7">
                                  <input type="text" ng-pattern="/^[0-9]+$/" ng-model="crctrl.conferenceroom.conferenceroomseats" name="crseats" class="username form-control input-sm" placeholder="Enter conference room max seats" required maxlength="5" ng-maxlength="5"/>
                                  <div class="has-error" ng-show="crmyForm.$dirty">
                                      <span ng-show="crmyForm.crseats.$error.required">This is a required field</span>
                                      
                                      <span ng-show="crmyForm.crseats.$error.pattern">Not a valid number!</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!crctrl.conferenceroom.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="crmyForm.$invalid">
                              <button type="button" ng-click="crctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="crmyForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">List of Conference Rooms </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Conference room name</th>
                              <th>Conference room location</th>
                              <th>Conference room max seats</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in crctrl.conferencerooms">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.conferenceRoomName"></span></td>
                              <td><span ng-bind="u.conferenceRoomLocation"></span></td>
                              <td><span ng-bind="u.conferenceroomseats"></span></td>
                              <td>
                              <button type="button" ng-click="crctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="crctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       <div class="generic-container" ng-controller="ConferenceController as cctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Conference Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="cctrl.submit()" name="cmyForm" class="form-horizontal">
                      <input type="hidden" ng-model="cctrl.conference.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference Room</label>
                              <div class="col-md-7">
                              <select name="corname" ng-options="cr.id as cr.conferenceRoomName for cr in conferencerooms" ng-model="cctrl.conference.conferenceroomid" required></select>
								 <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="cmyForm.corname.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="cctrl.conference.conferenceName" name="cname" class="username form-control input-sm" placeholder="Enter conference name" required required maxlength="150" ng-maxlength="150"/>
                                  <div class="has-error" ng-show="cmyForm.$dirty">
                                      <span ng-show="cmyForm.cname.$error.required">This is a required field</span>
                                      <span ng-show="cmyForm.cname.$error.maxlength">Max length required is 150</span>
                                      <span ng-show="cmyForm.cname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference date & time</label>
                              <div class="col-md-7">
                                  <input datetime-picker ng-pattern="/^(\d{2}).(\d{2}).(\d{4})[\ ](\d{2}):(\d{2})$/" date-format="dd.MM.yyyy HH:mm" ng-model="cctrl.conference.conferenceDateTime" name="conferencedatetime" placeholder="Enter confer. date&time" required required maxlength="16" ng-maxlength="16"/>
                                  <div class="has-error" ng-show="cmyForm.$dirty">
                                      <span ng-show="cmyForm.conferencedatetime.$error.required">This is a required field</span>
                                      <span ng-show="cmyForm.conferencedatetime.$invalid">This field is invalid </span>
                                      <span ng-show="cmyForm.conferencedatetime.$error.pattern">Not a valid date & time!</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!cctrl.conference.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="cmyForm.$invalid">
                              <button type="button" ng-click="cctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="cmyForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">List of Conferences </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Date & time</th>
                              <th>Conference room ID.</th>
                              <th>Conference room name</th>
                              <th>Conference room location</th>
                              <th>Conference free seats</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in cctrl.conferences">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.conferenceName"></span></td>
                              <td><span ng-bind="u.conferenceDateTime"></span></td>
                              <td><span ng-bind="u.conferenceroomid"></span></td>
                              <td><span ng-bind="u.conferroomname"></span></td>
                              <td><span ng-bind="u.conferroomlocation"></span></td>
                              <td><span ng-bind="u.freeseats"></span></td>
                              <td>
                              <button type="button" ng-click="cctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="cctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       <div class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Participant To Conference Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Conference</label>
                              <div class="col-md-7"> 
                              <select name="coname" ng-options="c.id as c.conferenceName for c in conferences" ng-model="ctrl.user.conferenceid" required></select>
								 <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.coname.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Full Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" name="uname" class="username form-control input-sm"  placeholder="Enter user full name" required required maxlength="150" ng-maxlength="150"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.maxlength">Max length required is 150</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Birth date</label>
                              <div class="col-md-7">
                               <input datetime-picker ng-pattern="/^(\d{2}).(\d{2}).(\d{4})$/" date-format="dd.MM.yyyy" ng-model="ctrl.user.birthdate" name="birthdate" placeholder="Enter user birthdate" required maxlength="10" ng-maxlength="10" required/>
                               <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.birthdate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.birthdate.$invalid">This field is invalid </span>
                                      <span ng-show="myForm.birthdate.$error.pattern">Not a valid date!</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Full name</th>
                              <th>Birth date</th>
                              <th>Conference ID.</th>
                              <th>Conference name</th>
                              <th>Conference time</th> 
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.username"></span></td>
                              <td><span ng-bind="u.birthdate"></span></td>
                              <td><span ng-bind="u.conferenceid"></span></td> 
                              <td><span ng-bind="u.confername"></span></td>
                              <td><span ng-bind="u.confertime"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/user_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
      <script src="<c:url value='/static/js/service/conference_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/conference_controller.js' />"></script>
      <script src="<c:url value='/static/js/service/conference_room_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/conference_room_controller.js' />"></script>
      <script src="<c:url value='/static/js/angularjs-datetime-picker.js' />"></script>
  </body>
</html>