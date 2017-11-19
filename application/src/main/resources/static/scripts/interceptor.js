angular.module('medWsApp')
  .factory('httpErrorInterceptor', function($q, $location) {
    return {
      'responseError': function(rejection) {
        // permission denied, better login!
        if(rejection.status === 403) {
          $location.url('/');
        }
        $q.reject(rejection);
      }
    };
  }).config(function($httpProvider) {
    $httpProvider.interceptors.push('httpErrorInterceptor');
  })
  
  .factory('httpProductRequestTransformationInterceptor', function($q, $location, $localStorage) {
    return {
      'request': function(config) {
          if($localStorage.token) {
        	  console.log('adicionando o token');
              config.headers.Authorization = 'Bearer ' + $localStorage.token;
          }
          return config;
      }
    };
  }).config(function($httpProvider) {
    $httpProvider.interceptors.push('httpProductReponseTransformationInterceptor');
  });