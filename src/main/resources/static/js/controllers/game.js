/**
 * 
 */
app.controller('gameController', function($scope, Factory) {
    
	$scope.id = Math.floor((Math.random()*10000000)+1);
	$scope.headingTitle = "Game";
	$scope.playerThrow = "No throw";
	$scope.computerThrow = "No throw";
	$scope.playerResult = "No result";
	$scope.win = 0;
	$scope.loose = 0;
	$scope.draw = 0;
	
	var paper = 0;
	var rock = 1;
	var scissors = 2;
	
	$scope.throws = {
		'paper': { value: paper, view: 'Paper'},
		'rock': { value: rock, view: 'Rock'},
		'scissors': { value: scissors, view: 'Scissors'}
	};
	
	var winMatrix = [];
	winMatrix[paper] = [];
	winMatrix[rock] = [];
	winMatrix[scissors] = [];
	winMatrix[paper][paper] = "Draw";
	winMatrix[paper][rock] = "Win";
	winMatrix[paper][scissors] = "Loose";
	winMatrix[rock][paper] = "Loose";
	winMatrix[rock][rock] = "Draw";
	winMatrix[rock][scissors] = "Win";
	winMatrix[scissors][paper] = "Win";
	winMatrix[scissors][rock] = "Loose";
	winMatrix[scissors][scissors] = "Draw";
	
	
	$scope.playerMove = function(gameMove) {
		$scope.playerThrow = gameMove.view;
		Factory.makeTurn($scope.id, gameMove).then(function(response){
	        $scope.computerThrow = response.data.view;
	        $scope.playerResult = winMatrix[gameMove.value][response.data.value];
	        if ($scope.playerResult === 'Win') {
	        	$scope.win++;
	        } else if ($scope.playerResult === 'Loose') {
	        	$scope.loose++;
	        } else {
	        	$scope.draw++;
	        }
	        if (angular.isDefined($scope.error)) {
	        	delete $scope.error;
	        }
	    }, function(error) {
	    	if (angular.isDefined(error)
	    			&& angular.isDefined(error.data)
	    			&& angular.isDefined(error.data.message)) {
	    		$scope.error = error.data.message;
	    	} else {
	    		$scope.error = "Error make turn";
	    	}
	    });
	}
	
	$scope.winner = function(playerThrow, computerThrow) {
		var matrix = [];
		matrix[0][0] = 'Draw';
		matrix[0][1] = 'Win';
		matrix[0][2] = 'Loose';
		matrix[1][0] = 'Loose';
		1,1
		1,2
		2,0
		2,1
		2,2
	}
});