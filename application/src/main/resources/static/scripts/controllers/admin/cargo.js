'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:CargoCtrl
 * @description
 * # CargoCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('CargoCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];
    
    Data.get('cargo/listarTodos').then(function(data){
      $scope.list = data;
    });
    
    // Modal Controller para criacao de Cargo
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/cargo/cargoCreate.html',
        controller: 'CargoCreateCtrl',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('cargo/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para edicao de Cargo
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/cargo/cargoEdit.html',
        controller: 'CargoEditCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('cargo/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do Cargo
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/cargo/cargoDelete.html',
        controller: 'CargoDeleteCtrl',
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
  
  // **************** CargoCreateCtrl ****************
  .controller('CargoCreateCtrl', function ($scope, $modalInstance, Data) 
  {
    $scope.item = {};
    $scope.item.ativo = 1;

    Data.get('status/listarTodos').then(function(data){
  	  $scope.list_status = data;
  	});
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.cargo_form.$valid) {
    	$scope.isDisabled = true;

	    Data.post('cargo/gravar', item).then(function (result) {
          var x = angular.copy(item);
          $modalInstance.close(x);

          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.cargo_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** CargoCreateCtrl ****************
  .controller('CargoEditCtrl', function ($scope, $modalInstance, item, Data) 
  {
	$scope.item = angular.copy(item);
	
	Data.get('status/listarTodos').then(function(data){
	  $scope.list_status = data;
	});
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.cargo_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('cargo/gravar', item).then(function (result) {
	      var x = angular.copy(item);
          $modalInstance.close(x);
	    	
	      $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.cargo_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** CargoDeleteCtrl ****************
  .controller('CargoDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);
    $scope.item.ativo = 0;

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.post("cargo/gravar", item).then(function(result) {
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
