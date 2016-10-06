'use strict';

angular.module('myApp').factory('ConferenceService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/testtask/conference/';
	
	var REST_SERVICE_URI_CONFERROOM = 'http://localhost:8080/testtask/conferenceroom/';

    var factory = {
		fetchAllConferenceRooms: fetchAllConferenceRooms,
        fetchAllConferences: fetchAllConferences,
        createConference: createConference,
        updateConference:updateConference,
        deleteConference:deleteConference
    };

    return factory;

	function fetchAllConferenceRooms() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_CONFERROOM)
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
	
    function fetchAllConferences() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Conferences');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createConference(conference) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, conference)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Conference');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateConference(conference, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, conference)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Conference');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteConference(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Conference');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
