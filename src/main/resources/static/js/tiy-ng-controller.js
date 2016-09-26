angular.module('TIYChatApp', [])
   .controller('SampleController', function($scope, $http) {

        $scope.sendMessage = function (messageText) {
            console.log("Sending message");

        $scope.post("//localhost:8080/sendMessage.json", $scope.newMessage, $scope.newUser)
           console.log("Posting message about to start");

           .then(
            function successCallback(response) {
                console.log("inside callback for posting messages")
                console.log(response.data);
                console.log("Adding data to scope");
                $scope.messages = response.data;
                },
                function errorCallback(response){
                    console.log ("Unable to get data in post message");
                });
                console.log("Done with the promise - waiting for the callback");
        };

        $scope.get("/history.json"){
            console.log("About to display the history");
            .then(
                function successCallback(response){
                    console.log("inside callback for history");
                    console.log(response.data);
                    console.log("Adding data to scope");

                },
                function errorCallback(response){
                    console.log("Unable to get data in history");
                });
                console.log("Done with the promise - waiting for the callback");
            };
       $scope.addUser = function() {
          console.log("About to add the following user " + JSON.stringify($scope.newUser));

          $http.post("/addUser.json", $scope.newUser)
              .then(
                  function successCallback(response) {
                     console.log("about to add a new user")
                     console.log(response.data);
                     console.log("Adding data to scope");
                     $scope.messages = response.data;
                  },
                  function errorCallback(response) {
                      console.log("Unable to add user data");
                  });
      };

       $scope.newMessage = {};
       $scope.newUser = {};

  });