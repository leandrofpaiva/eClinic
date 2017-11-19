'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:ConfiguracoesCtrl
 * @description
 * # ConfiguracoesCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('ConfiguracoesCtrl', function ($scope, $http) {
    $scope.list = [];
    /*$http.get('/json/config/configuracoes.json').success(function(data){
      $scope.list = data;
    });
	
	$scope.getTotal = function($scope)
    {
	  var vTotal = 0;
	  return vTotal;
    }*/
  }
);
