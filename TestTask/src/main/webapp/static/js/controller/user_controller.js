'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={id:null,username:'',birthdate:'', conferenceid:'', confername:'', confertime:''};
    self.users=[];

	self.conference={id:null,conferenceName:'',conferenceDateTime:'', conferenceroomid:'', conferroomname:'', conferroomlocation:'', freeseats:''};
	self.conferences=[];
	
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

	fetchAllConferences();

    function fetchAllConferences(){
        UserService.fetchAllConferences()
            .then(
            function(d) {
			
			for (var i=0; i<d.length; i++){
				
				if(d[i].freeseats == 0){
					d.splice(i,1);
				}
		
			}
                $scope.conferences = d;
            },
            function(errResponse){
                console.error('Error while fetching Conferences');
            }
        );
    }
	
    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createUser(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
		
		$scope.reloadPage = window.location.reload();
    }

    function submit() {
        if(self.user.id===null){
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
        }
        reset();
    }

    function edit(id){
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        if(self.user.id === id) {
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,username:'',birthdate:'', conferenceid:'', confername:'', confertime:''};
        $scope.myForm.$setPristine();
    }

}]);
