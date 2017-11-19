'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:EspecialidadeCtrl
 * @description
 * # EspecialidadeCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('EspecialidadeCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];
    
    Data.get('especialidade/listarTodos').then(function(data){
      $scope.list = data;
    });
    
    // Modal Controller para criacao de Especialidade
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/especialidade/especialidadeCreate.html',
        controller: 'EspecialidadeCreateCtrl',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('especialidade/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para edicao de Especialidade
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/especialidade/especialidadeEdit.html',
        controller: 'EspecialidadeEditCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('especialidade/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do Especialidade
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/especialidade/especialidadeDelete.html',
        controller: 'EspecialidadeDeleteCtrl',
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
  
  // **************** EspecialidadeCreateCtrl ****************
  .controller('EspecialidadeCreateCtrl', function ($scope, $modalInstance, Data) 
  {
    $scope.item = {};
    $scope.item.ativo = 1;

    Data.get('status/listarTodos').then(function(data){
  	  $scope.list_status = data;
  	});
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.especialidade_form.$valid) {
    	$scope.isDisabled = true;

	    Data.post('especialidade/gravar', item).then(function (result) {
          var x = angular.copy(item);
          $modalInstance.close(x);

          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.especialidade_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** EspecialidadeCreateCtrl ****************
  .controller('EspecialidadeEditCtrl', function ($scope, $modalInstance, item, Data) 
  {
	$scope.item = angular.copy(item);
	
	Data.get('status/listarTodos').then(function(data){
	  $scope.list_status = data;
	});
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.especialidade_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('especialidade/gravar', item).then(function (result) {
	      var x = angular.copy(item);
          $modalInstance.close(x);
	    	
	      $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.especialidade_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** EspecialidadeDeleteCtrl ****************
  .controller('EspecialidadeDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);
    $scope.item.ativo = 0;

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.post("especialidade/gravar", item).then(function(result) {
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
