'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:StatusCtrl
 * @description
 * # StatusCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('StatusCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];
    
    Data.get('status/listarTodos').then(function(data){
      $scope.list = data;
    });
    
    // Modal Controller para criacao de Status
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/config/status/statusCreate.html',
        controller: 'StatusCreateCtrl',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('status/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para edicao de Status
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/config/status/statusEdit.html',
        controller: 'StatusEditCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('status/list').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do Status
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/config/status/statusDelete.html',
        controller: 'StatusDeleteCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }          
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        $scope.list = _.without($scope.list, _.findWhere($scope.list, {id:selectedObject.id}));
      });
    };
  })
  
  // **************** StatusCreateCtrl ****************
  .controller('StatusCreateCtrl', function ($scope, $modalInstance, Data) 
  {
    $scope.item = {};
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.status_form.$valid) {
    	$scope.isDisabled = true;

	    Data.post('status/gravar', item).then(function (result) {
          var x = angular.copy(item);
          $modalInstance.close(x);

          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.status_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** StatusCreateCtrl ****************
  .controller('StatusEditCtrl', function ($scope, $modalInstance, item, Data) 
  {
	$scope.item = angular.copy(item);

	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.status_form.$valid) {
    	$scope.isDisabled = true;
	    Data.put('status/gravar', item).then(function (result) {
	      var x = angular.copy(item);
          $modalInstance.close(x);
	    	
	      $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.status_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** StatusDeleteCtrl ****************
  .controller('StatusDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);
    $scope.item.ativo = 0;

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.post("status/gravar", item).then(function(result) {
        var x = angular.copy(item);
  	    $modalInstance.close(x);

    	$modalInstance.dismiss('Close');
      });
    }

    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  });
