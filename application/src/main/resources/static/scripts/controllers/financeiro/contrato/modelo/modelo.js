'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:ModeloContratoCtrl
 * @description
 * # ModeloContratoCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('ModeloContratoCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];

    Data.get('ModeloContrato/listAll').then(function(data){
      if (data.status == 'success') {
        $scope.list = data.data;
      }
    });
    
    $scope.customMenu = [
                          ['bold', 'italic', 'underline', 'strikethrough', 'subscript', 'superscript'],
                          ['font'],
                          ['font-size'],
                          ['font-color', 'hilite-color'],
                          ['remove-format'],
                          ['ordered-list', 'unordered-list', 'outdent', 'indent'],
                          ['left-justify', 'center-justify', 'right-justify'],
                          ['code', 'quote', 'paragraph'],
                          ['link', 'image'],
                          ['field']
                        ];
    
    // Modal Controller para criacao de ModeloContrato
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/modelos/contrato/contratoCreate.html',
        controller: 'ModeloContratoCreateCtrl',
        backdrop: 'static',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('ModeloContrato/listAll').then(function(data){
          if (data.status == 'success') {
            $scope.list = data.data;
          }
        });
      });
    };
	
	// Modal Controller para edicao de ModeloContrato
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/modelos/contrato/contratoEdit.html',
        controller: 'ModeloContratoEditCtrl',
        backdrop: 'static',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('ModeloContrato/listAll').then(function(data){
          if (data.status == 'success') {
            $scope.list = data.data;
          }
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do ModeloContrato
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/admin/modelos/contrato/contratoDelete.html',
        controller: 'ModeloContratoDeleteCtrl',
        backdrop: 'static',
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

  // **************** ModeloContratoCreateCtrl ****************
  .controller('ModeloContratoCreateCtrl', function ($scope, $modalInstance, $filter, Data) 
  {
	$scope.item = {};
	$scope.item.ativo = 1;
	    
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.contrato_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('ModeloContrato/save', item).then(function (result) {
          if(result.status != 'error'){
            var x = angular.copy(item);
            $modalInstance.close(x);
          }else{
           console.log(result);
          }
          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.contrato_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** ModeloContratoCreateCtrl ****************
  .controller('ModeloContratoEditCtrl', function ($scope, $modalInstance, item, $filter, Data) 
  {
	$scope.item = angular.copy(item);
	$scope.item.id_status = item.id_status;
	
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.contrato_form.$valid) {
    	$scope.isDisabled = true;
    	
	    Data.post('ModeloContrato/save', item).then(function (result) {
          if(result.status != 'error'){
            var x = angular.copy(item);
            $modalInstance.close(x);
          }else{
           console.log(result);
          }
          $modalInstance.dismiss('Close');
        });
	  } else {
		$scope.contrato_form.submitted = true;
	  }
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  
  // **************** ModeloContratoDeleteCtrl ****************
  .controller('ModeloContratoDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.get("ModeloContrato/delete/" + item.id).then(function(result) {
        if(result.status == 'success'){
          var x = angular.copy(item);
          $modalInstance.close(x);
        }else{
         console.log(result);
        }
                    
        $modalInstance.dismiss('Close');
      });
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
  })
  ;
