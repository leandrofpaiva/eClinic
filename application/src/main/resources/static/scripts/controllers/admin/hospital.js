'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:HospitalCtrl
 * @description
 * # HospitalCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('HospitalCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];
    
    Data.get('hospital/listarTodos').then(function(data){
      $scope.list = data;
    });
    
    // Modal Controller para criacao de Hospital
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/hospital/hospitalCreate.html',
        controller: 'HospitalCreateCtrl',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('hospital/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para edicao de Hospital
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/hospital/hospitalEdit.html',
        controller: 'HospitalEditCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('hospital/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do Hospital
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/hospital/hospitalDelete.html',
        controller: 'HospitalDeleteCtrl',
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
  
  // **************** HospitalCreateCtrl ****************
  .controller('HospitalCreateCtrl', function ($scope, $modalInstance, Data) 
  {
    $scope.item = {};
    $scope.item.ativo = 1;

    Data.get('status/listarTodos').then(function(data){
  	  $scope.list_status = data;
  	});
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.hospital_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('hospital/gravar', item).then(function (result) {
          var x = angular.copy(item);
          $modalInstance.close(x);

          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.hospital_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** HospitalCreateCtrl ****************
  .controller('HospitalEditCtrl', function ($scope, $modalInstance, item, Data) 
  {
	$scope.item = angular.copy(item);
	
	Data.get('status/listarTodos').then(function(data){
	  $scope.list_status = data;
	});
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.hospital_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('hospital/gravar', item).then(function (result) {
	      var x = angular.copy(item);
          $modalInstance.close(x);
	    	
	      $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.hospital_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** HospitalDeleteCtrl ****************
  .controller('HospitalDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);
    $scope.item.ativo = 0;

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.post("hospital/gravar", item).then(function(result) {
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
