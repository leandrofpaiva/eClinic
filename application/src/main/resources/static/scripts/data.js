app.factory("Data", ['$http',
  function ($http, $q) {

    var serviceBase = '/api/';
    //var serviceBase = 'http://haggle.com.br:8080/';

    var obj = {};

    obj.get = function (q) {
      return $http.get(serviceBase + q).then(function (results) {
        return results.data;
      });
    };

    obj.post = function (q, object) {
      return $http.post(serviceBase + q, object).then(function (results) {
        return results.data;
      });
    };
    
    obj.post = function (q, object, param) {
      return $http.post(serviceBase + q, object, param).then(function (results) {
        return results.data;
      });
    };

    obj.put = function (q, object) {
      return $http.put(serviceBase + q, object).then(function (results) {
        return results.data;
      });
    };

    obj.delete = function (q) {
      return $http.delete(serviceBase + q).then(function (results) {
        return results.data;
      });
    };

    return obj;
}]);
