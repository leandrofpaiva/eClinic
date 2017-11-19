'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:ContratoCtrl
 * @description
 * # ContratoCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('ContratoCtrl', function ($scope, $resource, $modal, $filter, Data) {
    // inicializando a listagem na tela
    $scope.list = [];

    Data.get('Contrato/listAll').then(function(data){
      if (data.status == 'success') {
        $scope.list = data.data;
      }
    });
    
    // Modal Controller para criacao de Contrato
    $scope.openCreate = function () {
      var modalInstance = $modal.open({
        templateUrl: 'views/escola/contrato/contratoCreate.html',
        controller: 'ContratoCreateCtrl',
        backdrop: 'static',
        scope: $scope
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('Contrato/listAll').then(function(data){
          if (data.status == 'success') {
            $scope.list = data.data;
          }
        });
      });
    };
	
	// Modal Controller para edicao de Contrato
    $scope.openEdit = function (p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/escola/contrato/contratoEdit.html',
        controller: 'ContratoEditCtrl',
        backdrop: 'static',
        scope: $scope,
        resolve: {
          item: function () {
            return p;
          }
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('Contrato/listAll').then(function(data){
          if (data.status == 'success') {
            $scope.list = data.data;
          }
        });
      });
    };
	
	// Modal Controller para realizacao do exclusao do Contrato
    $scope.openDelete = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/escola/contrato/contratoDelete.html',
        controller: 'ContratoDeleteCtrl',
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
    
    // Modal Controller para realizacao do Impressao do contrato
    $scope.openPrint = function(p) {
      var modalInstance = $modal.open({
        templateUrl: 'views/escola/contrato/contratoPrint.html',
        controller: 'ContratoPrintCtrl',
        scope: $scope,
        backdrop: 'static',
        windowClass: 'app-modal-window',
        resolve: {
          item: function () {
            return p;
          }          
        }
      });
      
      modalInstance.result.then(function(selectedObject) {
        Data.get('Contrato/listAll').then(function(data){
          if (data.status == 'success') {
            $scope.tutor = data.data;
          }
        });
      });
    };
	
  })
  
  // **************** ContratoCreateCtrl ****************
  .controller('ContratoCreateCtrl', function ($scope, $modalInstance, $filter, Data) 
  {
	$scope.item = {};
	$scope.item.ativo = 1;
	$scope.item.data_cadastro = $filter('date')(new Date(), 'dd/MM/yyyy');    
    
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.contrato_form.$valid) {
    	$scope.isDisabled = true;
    	console.log(item);
	    Data.post('Contrato/save', item).then(function (result) {
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
  
  // **************** ContratoCreateCtrl ****************
  .controller('ContratoEditCtrl', function ($scope, $modalInstance, item, $filter, Data) 
  {
	$scope.item = angular.copy(item);
	
    // Funcao para realizacao do extorno
    $scope.saveItem = function (item) {
      if ($scope.contrato_form.$valid) {
    	$scope.isDisabled = true;
	    Data.post('Contrato/save', item).then(function (result) {
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
  
  // **************** ContratoDeleteCtrl ****************
  .controller('ContratoDeleteCtrl', function ($scope, $modalInstance, item, Data) 
  {
    $scope.item = angular.copy(item);

    // Metodo para realizacao do extorno
    $scope.deleteItem = function (item) {
      Data.get("Contrato/delete/" + item.id).then(function(result) {
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
  
  // **************** RecebimentoPrintCtrl ****************
  .controller('ContratoPrintCtrl', function ($scope, $modalInstance, $sce, item, Data) 
  {
	var renderHTML = item.modelo.replace("\[nome\]", item.aluno);
	renderHTML = renderHTML.replace("\[endereco\]", item.endereco);
	renderHTML = renderHTML.replace("\[cidade\]", item.cidade);
	renderHTML = renderHTML.replace("\[cpf\]", item.cpf);
	renderHTML = renderHTML.replace("\[plano\]", item.plano);
	
	//console.log(renderHTML);
	
	$scope.renderHtml = function () {
	  return $sce.trustAsHtml(renderHTML);
	};

    $scope.print = function(divName) {
      var printContents = $("#printable").html();
      var popupWin = window.open('', '_blank', 'width=900,height=900');
      popupWin.document.open()
      popupWin.document.write(
    	  '<html>' +
    	  '<head>' +
    	  ' <meta charset="utf-8">' + 
    	  ' <meta name="viewport" content="width=device-width, initial-scale=1.0">' +
    	  ' <title>Contrato</title>' +
    	  ' <link href="/styles/bootstrap.css" rel="stylesheet">' +
    	  ' <link href="/styles/bootstrap-select.min.css" rel="stylesheet">' +
    	  ' <link href="/bower_components/font-awesome/css/font-awesome.css" rel="stylesheet">' +
    	  ' <link href="/styles/sb-admin.css" rel="stylesheet">' +
    	  '</head> ' + '<script src="/scripts/libs/bootstrap.min.js"></script></head><body onload="window.print()">' + printContents + '</html>');
      popupWin.document.close();
    }
    
    // Metodo para fechar a Janela Modal
    $scope.cancel = function () {
      $modalInstance.dismiss('Close');
    };
    
  });
