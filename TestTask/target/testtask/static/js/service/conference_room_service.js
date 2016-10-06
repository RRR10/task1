'use strict';

angular.module('myApp').factory('ConferenceRoomService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/testtask/conferenceroom/';

    var factory = {
        fetchAllConferenceRooms: fetchAllConferenceRooms,
        createConferenceRoom: createConferenceRoom,
        updateConferenceRoom:updateConferenceRoom,
        deleteConferenceRoom:deleteConferenceRoom
    };

    return factory;

    function fetchAllConferenceRooms() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
				
            },
            function(errResponse){
                console.error('Error while fetching ConferenceRooms');
                deferred.reject(errResponse);
            }
        );
		
		
        return deferred.promise;
    }

    function createConferenceRoom(conferenceroom) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, conferenceroom)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating ConferenceRoom');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateConferenceRoom(conferenceroom, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, conferenceroom)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating ConferenceRoom');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteConferenceRoom(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting ConferenceRoom');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
