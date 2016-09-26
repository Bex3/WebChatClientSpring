angular.module('TIYChatApp', [])
   .controller('SampleController', function($scope, $http) {

        $scope.sendMessage = function (messageText) {
            console.log("Sending message");

        $scope.get("//localhost:8080/sendMessage.json?messageText=" + messageText)
           .then(
            function successCallback(response) {
                console.log(response.data);
                console.log("Adding data to scope");
                $scope.messages = response.data;
                },
                function errorCallback(response){
                    console.log ("Unable to get data");
                });
                console.log("Done with the promise - waiting for the callback");
        };
  });