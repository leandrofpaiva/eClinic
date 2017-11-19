'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:FuncionarioCtrl
 * @description
 * # FuncionarioCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('UsuarioCtrl', function ($scope, $localStorage, $resource, $modal, $filter, Data) {

    $scope.changePassword = function(item) {
      if ($scope.alterar_senha_form.$valid) {
    	item.id = $localStorage.get('mnx_id');

    	if (item.password_hash != item.cpassword_hash) {
    	  $scope.message = "Senhas não Conferem!";
    	} else {
    	  Data.post('Usuario/save', item).then(function (result) {
    		if(result.status != 'error'){
    	      $scope.message = "Senha Alterada com Sucesso!";
    	    }else{
    	      console.log(result);
    	    }
    	  });
    	}
	  } else {
		$scope.alterar_senha_form.submitted = true;
	  }
    }
  });  
