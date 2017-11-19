'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:ProfissionalCtrl
 * @description
 * # ProfissionalCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('ProfissionalCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];
    
    Data.get('profissional/listarTodos').then(function(data){
      $scope.list = data;
    });
    
    // Modal Controller para criacao de Profissional
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/profissional/profissionalCreate.html',
        controller: 'ProfissionalCreateCtrl',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('profissional/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para edicao de Profissional
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/profissional/profissionalEdit.html',
        controller: 'ProfissionalEditCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('profissional/listarTodos').then(function(data){
          $scope.list = data;
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do Profissional
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/profissional/profissionalDelete.html',
        controller: 'ProfissionalDeleteCtrl',
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
  
  // **************** ProfissionalCreateCtrl ****************
  .controller('ProfissionalCreateCtrl', function ($scope, $modalInstance, Data) 
  {
    $scope.item = {};
    $scope.item.ativo = 1;

    Data.get('status/listarTodos').then(function(data){
  	  $scope.list_status = data;
  	});
	
    Data.get('especialidade/listarTodosCombo').then(function(data){
      $scope.list_especialidade = data;
    });
    
    Data.get('cargo/listarTodosCombo').then(function(data){
      $scope.list_cargo = data;
    });    
    
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.profissional_form.$valid) {
    	$scope.isDisabled = true;

	    Data.post('profissional/gravar', item).then(function (result) {
          var x = angular.copy(item);
          $modalInstance.close(x);

          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.profissional_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** ProfissionalCreateCtrl ****************
  .controller('ProfissionalEditCtrl', function ($scope, $modalInstance, item, Data) 
  {
	$scope.item = angular.copy(item);
	
	Data.get('status/listarTodos').then(function(data){
	  $scope.list_status = data;
	});
	
    Data.get('especialidade/listarTodosCombo').then(function(data){
      $scope.list_especialidade = data;
    });
      
    Data.get('cargo/listarTodosCombo').then(function(data){
      $scope.list_cargo = data;
    });  
      
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.profissional_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('profissional/gravar', item).then(function (result) {
	      var x = angular.copy(item);
          $modalInstance.close(x);
	    	
	      $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.profissional_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** ProfissionalDeleteCtrl ****************
  .controller('ProfissionalDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);
    $scope.item.ativo = 0;

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.post("profissional/gravar", item).then(function(result) {
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
