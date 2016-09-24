angular.module('TIYChatApp', [])
   .controller('SampleController', function($scope, $http) {

        $scope.getMessages = function() {
            console.log("About to go get me some data!");
            $scope.name = "JavaScript Master Guru";

            $http.get("//localhost:8080/games.json") //asynch call
                .then( //provides the callback
                    function successCallback(response) { //inside of the promise object then holds the 2 functions
                        console.log(response.data); //data is the json object as a javascript object
                        console.log("Adding data to scope");
                        $scope.messages = response.data;
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    });
                    console.log("Done with the promise - waiting for the callback");
        };