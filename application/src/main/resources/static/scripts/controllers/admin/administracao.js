'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:AdministracaoCtrl
 * @description
 * # AdministracaoCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('AdministracaoCtrl', function ($scope, $http) {
    $scope.list = [];
    /*$http.get('/json/admin/administracao.json').success(function(data){
      $scope.list = data;
    });
	
	$scope.getTotal = function($scope)
    {
	  var vTotal = 0;
	  return vTotal;
    }*/
  }
);
