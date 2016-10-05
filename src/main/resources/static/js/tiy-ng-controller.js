angular.module('TIYChatApp', [])
   .controller('SampleController', function($scope, $http) {

        $scope.messageList = {};


//        $scope.getHistory = function() {
//            console.log("About to get the history...");
//
//                $http.get("//localhost:8080/getMessages.json")
//                    .then(
//                        function successCallback(response) {
//                            console.log("inside callback for history");
//                            console.log(response.data);
//                            console.log("Adding data to scope");
//                            $scope.messageList = response.data;
//
//                        },
//                            function errorCallback(response) {
//                                console.log("Unable to get data in history");
//                        });
//                        console.log("Done with the promise - waiting for the callback");
//
//                    };


        $scope.getHistory = function() {
            console.log("About to get message history");
            $http.get("//localhost:8080/getMessages.json")
            .then(
                function successCallBack(response) {
                    console.log(response.data);
                    console.log("retrieving messages");
                    $scope.messageList = response.data;
                    console.log($scope.messageList);
                },
                function errorCallBack(response) {
                    console.log("Unable to retrieve messages");
                });
             console.log("Done with the callback");
        };


        $scope.sendMessage = function (messageText) {
            console.log("Sending message");

        $scope.post("/sendMessage.json", $scope.newMessage, $scope.user)
           console.log("Posting message about to start")

           .then(
            function successCallback(response) {
                console.log("inside callback for posting messages");
                console.log(response.data);
                console.log("Adding data to scope");


                $scope.messages = response.data;
                },
                function errorCallback(response){
                    console.log ("Unable to get data in post message");
                });
                console.log("Done with the promise - waiting for the callback");
        };

       $scope.addUser = function() {
          console.log("About to add the following user " + JSON.stringify($scope.user));

          $http.post("/addUser.json", $scope.newUser)
              .then(
                  function successCallback(response) {
                     console.log("about to add a new user");
                     console.log(response.data);
                     console.log("Adding data to scope");
                     $scope.messages = response.data;

                  },
                  function errorCallback(response) {
                      console.log("Unable to add user data");
                  });
      };

       $scope.newMessage = {};


  });