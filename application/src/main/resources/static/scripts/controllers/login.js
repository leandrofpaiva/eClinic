'use strict';

/**
 * @ngdoc function
 * @name medWsApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the medWsApp
 */
angular.module('medWsApp')
  .controller('LoginCtrl', function ($scope, $location, $window, $localStorage, AuthenticationService, AclService, jwtHelper) {
    initController();

    function initController() {
      // reset login status
      AuthenticationService.Logout();
    };

    $scope.login = function(item) {
      AuthenticationService.Login(item, function (result) {
        if (result === true) {
          // levar para atuh.js
          var tokenPayload = jwtHelper.decodeToken($localStorage.currentUser.token);
          angular.forEach(tokenPayload.roles, function(role) {
          AclService.attachRole(role.authority);
      	});

          $window.location='/main.html';
        } else {
          $scope.hasError = true;
          $scope.error_msg = 'Usuário ou senha incorretos';
        }
      });
    };
  });
