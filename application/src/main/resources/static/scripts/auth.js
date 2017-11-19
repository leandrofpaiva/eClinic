(function () {
  'use strict';

  angular
    .module('medWsApp')
    .factory('AuthenticationService', Service);

  function Service($http, $localStorage) {
    var service = {};

    service.Login = Login;
    service.Logout = Logout;

    return service;

    function Login(item, callback) {
      $http.post('/auth/login', item).success(function (response) {
        // login successful if there's a token in the response
        if (response.token) {
          // store username and token in local storage to keep user logged in between page refreshes
          $localStorage.currentUser = { username: item.email, token: response.token };
          // execute callback with true to indicate successful login
          callback(true);
        } else {
          // execute callback with false to indicate failed login
          callback(false);
        }
      }).error(function (response) {
        callback(false);
      });
    }

    function Logout() {
      // remove user from local storage and clear http auth header
      delete $localStorage.currentUser;
      $http.defaults.headers.common.Authorization = '';
    }
        
    function isLoggedIn () {
      return $sessionStorage.currentUser != null;
    };
  }
})();