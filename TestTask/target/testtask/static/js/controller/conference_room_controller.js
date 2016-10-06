'use strict';

angular.module('myApp').controller('ConferenceRoomController', ['$scope', 'ConferenceRoomService', function($scope, ConferenceRoomService) {
    var self = this;
    self.conferenceroom={id:null,conferenceRoomName:'',conferenceRoomLocation:'', conferenceroomseats:''};
    self.conferencerooms=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllConferenceRooms();

    function fetchAllConferenceRooms(){
        ConferenceRoomService.fetchAllConferenceRooms()
            .then(
            function(d) {
                self.conferencerooms = d;
				
            },
            function(errResponse){
                console.error('Error while fetching ConferenceRooms');
            }
        );
		
		
    }
	
    function createConferenceRoom(conferenceroom){
        ConferenceRoomService.createConferenceRoom(conferenceroom)
            .then(
            fetchAllConferenceRooms,
            function(errResponse){
                console.error('Error while creating ConferenceRoom');
            }
        );
		
		
		$scope.reloadPage = window.location.reload();
    }

    function updateConferenceRoom(conferenceroom, id){
        ConferenceRoomService.updateConferenceRoom(conferenceroom, id)
            .then(
            fetchAllConferenceRooms,
            function(errResponse){
                console.error('Error while updating ConferenceRoom');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function deleteConferenceRoom(id){
        ConferenceRoomService.deleteConferenceRoom(id)
            .then(
            fetchAllConferenceRooms,
            function(errResponse){
                console.error('Error while deleting ConferenceRoom');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function submit() {
        if(self.conferenceroom.id===null){
            createConferenceRoom(self.conferenceroom);
        }else{
            updateConferenceRoom(self.conferenceroom, self.conferenceroom.id);
        }
        reset();
    }

    function edit(id){
        for(var i = 0; i < self.conferencerooms.length; i++){
            if(self.conferencerooms[i].id === id) {
                self.conferenceroom = angular.copy(self.conferencerooms[i]);
                break;
            }
        }
    }

    function remove(id){
        if(self.conferenceroom.id === id) {
            reset();
        }
        deleteConferenceRoom(id);
    }


    function reset(){
        self.conferenceroom={id:null,conferenceroomname:'',conferenceroomlocation:'', conferenceroomseats:''};
        $scope.crmyForm.$setPristine();
    }

}]);
