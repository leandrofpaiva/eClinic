'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('MainCtrl', function ($scope, $localStorage, $window, AuthenticationService, AclService) {
    $scope.can = AclService.can;
    
    $scope.username = $localStorage.currentUser.username;
    
    // fechando a sessao
    $scope.logout = function () {
      AuthenticationService.Logout();
      AclService.flushRoles();
      $window.location = "/index.html";
    }
  })
;
