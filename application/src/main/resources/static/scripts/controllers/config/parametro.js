'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:ParametroCtrl
 * @description
 * # ParametroCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('ParametroCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];
    
    Data.get('parametro/listarTodos').then(function(data){
      if (data.status == 'success') {
        $scope.list = data.data;
      }
    });
    
	// Modal Controller para edicao de Parametro
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/config/parametro/parametroEdit.html',
        controller: 'ParametroEditCtrl',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('parametro/listarTodos').then(function(data){
          if (data.status == 'success') {
            $scope.list = data.data;
          }
        });
      });
    };
  })
  
  // **************** ParametroCreateCtrl ****************
  .controller('ParametroEditCtrl', function ($scope, $modalInstance, item, Data) 
  {
	$scope.item = angular.copy(item);
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.parametro_form.$valid) {
	    Data.post('parametro/gravar', item).then(function (result) {
          if(result.status != 'error'){
            var x = angular.copy(item);
            $modalInstance.close(x);
          }else{
           console.log(result);
          }
          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.parametro_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  });
