'use strict';

angular.module('myApp').controller('ConferenceController', ['$scope', 'ConferenceService', function($scope, ConferenceService) {
    var self = this;
    self.conference={id:null,conferenceName:'',conferenceDateTime:'', conferenceroomid:'', conferroomname:'', conferroomlocation:'', freeseats:''};
    self.conferences=[];

	self.conferenceroom={id:null,conferenceRoomName:'',conferenceRoomLocation:'', conferenceroomseats:''};
    self.conferencerooms=[];
	
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

	fetchAllConferenceRooms();

    function fetchAllConferenceRooms(){
        ConferenceService.fetchAllConferenceRooms()
            .then(
            function(d) {
                $scope.conferencerooms = d;
            },
            function(errResponse){
                console.error('Error while fetching ConferenceRooms');
            }
        );
    }

    fetchAllConferences();

    function fetchAllConferences(){
        ConferenceService.fetchAllConferences()
            .then(
            function(d) {
                self.conferences = d;
				
            },
            function(errResponse){
                console.error('Error while fetching Conferences');
            }
        );
    }

    function createConference(conference){
        ConferenceService.createConference(conference)
            .then(
            fetchAllConferences,
            function(errResponse){
                console.error('Error while creating Conference');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function updateConference(conference, id){
        ConferenceService.updateConference(conference, id)
            .then(
            fetchAllConferences,
            function(errResponse){
                console.error('Error while updating Conference');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function deleteConference(id){
        ConferenceService.deleteConference(id)
            .then(
            fetchAllConferences,
            function(errResponse){
                console.error('Error while deleting Conference');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function submit() {
        if(self.conference.id===null){
            createConference(self.conference);
        }else{
            updateConference(self.conference, self.conference.id);
        }
        reset();
    }

    function edit(id){
        for(var i = 0; i < self.conferences.length; i++){
            if(self.conferences[i].id === id) {
                self.conference = angular.copy(self.conferences[i]);
                break;
            }
        }
    }

    function remove(id){
        if(self.conference.id === id) {
            reset();
        }
        deleteConference(id);
    }


    function reset(){
        self.conference={id:null,conferencename:'',conferencedatetime:'', conferenceroomid:'', conferroomname:'', conferroomlocation:'', freeseats:''};
        $scope.cmyForm.$setPristine();
    }

}]);
