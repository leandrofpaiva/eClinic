'use strict';

/**
 * @ngdoc overview
 * @name medWsApp
 * @description
 * # medWsApp
 * 
 * Main module of the application.
 */
var app = angular
  .module('medWsApp', [
    /*'ngCookies',*/
    'ngResource',
    'ngRoute',
    'ngStorage',
    'ngMask',
    'ui.calendar',
    'ui.bootstrap',
    'ui.bootstrap.timepicker',
    'datatables',
    'ui.utils',
    'ui.utils.masks',
    'pascalprecht.translate',
    //'jerryhsia.minieditor',
    //'wysiwyg.module',
    'checklist-model',
    'flash',
    'chieffancypants.loadingBar',
    'ngAnimate',
    'angular-jwt',
    'mm.acl' // angular-acl
  ]).config(function(cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeSpinner = true;
  });

  app.config(function($translateProvider) {
    $translateProvider.translations('pt', {
      MENU_HOME: 'Dashboard',
      MENU_CONTA: 'Conta Corrente',
      MENU_RELATORIOS: 'Relatórios',
      MENU_ADMINISTRACAO: 'Administração',
      MENU_CONTRATO: 'Contrato',
      MENU_CONFIGURACAO: 'Configurações',
      MENU_PARAMETRO: 'Parâmetro',
      MENU_FINANCEIRO: 'Financeiro',
      MENU_ALTERAR_SENHA: 'Alterar Senha',
      MENU_MODELO_CONTRATO: 'Modelos de Contrato',
      MENU_SAIR: 'Sair',
      LABEL_NOME_SISTEMA: 'PlantoMed',
      LABEL_VISUALIZAR: 'Visualizar',
      LABEL_ADMINISTRACAO: 'Administração',
      LABEL_CARGO: 'Cargo',
      LABEL_ESPECIALIDADE: 'Especialidade',
      LABEL_HOSPITAL: 'Hospital',
      LABEL_PROFISSIONAL: 'Profissional',
      LABEL_DESCRICAO: 'Descrição',
      LABEL_STATUS: 'Status',
      LABEL_VOLTAR: 'Voltar'
    }).translations('en', {
      MENU_HOME: 'Dashboard',
      MENU_CONTA: 'Conta Corrente',
      MENU_RELATORIOS: 'Relatórios',
      MENU_ADMINISTRACAO: 'Administração',
      MENU_CONTRATO: 'Contrato',
      MENU_CONFIGURACAO: 'Configurações',
      MENU_PARAMETRO: 'Parâmetro',
      MENU_FINANCEIRO: 'Financeiro',
      MENU_ALTERAR_SENHA: 'Alterar Senha',
      MENU_MODELO_CONTRATO: 'Modelos de Contrato',
      MENU_SAIR: 'Sair',
      LABEL_NOME_SISTEMA: 'PlantoMed',
      LABEL_VISUALIZAR: 'Visualizar',
      LABEL_VOLTAR: 'Voltar'
    });

    $translateProvider.preferredLanguage('pt');
    $translateProvider.useSanitizeValueStrategy('escape');
  });

  app.config(function ($routeProvider, $httpProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl'
      })

      // Modulo Admin
      .when('/administracao', {
        templateUrl: 'views/admin/administracao.html',
        controller: 'AdministracaoCtrl',
        title: 'Administração'
      })

      .when('/cargo', {
        templateUrl: 'views/admin/cargo/cargo.html',
        controller: 'CargoCtrl',
        title: 'Cargo'
      })

      .when('/especialidade', {
        templateUrl: 'views/admin/especialidade/especialidade.html',
        controller: 'EspecialidadeCtrl',
        title: 'Especialidade'
      })

      .when('/hospital', {
        templateUrl: 'views/admin/hospital/hospital.html',
        controller: 'HospitalCtrl',
        title: 'Hospital'
      })

      .when('/profissional', {
        templateUrl: 'views/admin/profissional/profissional.html',
        controller: 'ProfissionalCtrl',
        title: 'profissional'
      })

      // Módulo Admin / Usuario
      .when('/alterarSenha', {
        templateUrl: 'views/admin/usuario/alterarSenha.html',
        controller: 'UsuarioCtrl',
        title: 'Usuários'
      })
      
      // Modulo Config
      .when('/configuracoes', {
        templateUrl: 'views/config/configuracoes.html',
        controller: 'ConfiguracoesCtrl',
        title: 'Configurações'
      })

      .when('/parametros', {
        templateUrl: 'views/config/parametro/parametro.html',
        controller: 'ParametroCtrl',
        title: 'Parametro'
      })

      .when('/status', {
        templateUrl: 'views/config/status/status.html',
        controller: 'StatusCtrl',
        title: 'Status'
      })
      
      // Modulo CRM 

      
      // Modulo Financeiro
      .when('/contrato', {
        templateUrl: 'views/financeiro/contrato/contrato.html',
        controller: 'ContratoCtrl',
        title: 'Contratos'
      })
      
      // Modulo Contrato / Modelo
      .when('/modelo', {
        templateUrl: 'views/financeiro/contrato/modelo.html',
        controller: 'ModeloContratoCtrl',
        title: 'Modelo de Contratos'
      })

      .otherwise({
        redirectTo: '/'
      });
    
    $httpProvider.interceptors.push(['$q', '$location', '$localStorage', function($q, $window, $localStorage) {
      return {
        request: function (config) {
          //config.headers = config.headers || {};
          if ($localStorage.token) {
            config.headers.Authorization = 'Bearer ' + $localStorage.currentUser.token;
            //console.log(config);
          }
          return config || $q.when(config);
        },
        responseError: function(response) {
          if(response.status === 401 || response.status === 403) {
        	$window.location = "/index.html";
          }
          return $q.reject(response);
        }
      };
    }]);
  });

  app.config(['AclServiceProvider', function (AclServiceProvider) {
    var myConfig = {
      storage: 'localStorage',
      storageKey: 'AclService'
    };
    AclServiceProvider.config(myConfig);
  }]);

  app.run(function ($rootScope, $http, $window, $location, $localStorage, AclService, jwtHelper) {
	if (!AclService.resume()) {
	  var aclData = {
        ADMIN: ['admin'],
        HOSPITAL: ['hospital'],
        PROFISSIONAL: ['profissional']
	  }
	  AclService.setAbilities(aclData);
	  
	  if ($localStorage.currentUser && $localStorage.currentUser.token) {
		var tokenPayload = jwtHelper.decodeToken($localStorage.currentUser.token);
	    //console.log($localStorage.currentUser.token);
	    angular.forEach(tokenPayload.roles, function(role) {
          AclService.attachRole(role.authority);
    	});
	  }
	}

	if ($localStorage.currentUser) {
	  $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
	}
		
    // redirect to login page if not logged in and trying to access a restricted page
    $rootScope.$on('$locationChangeStart', function (event, next, current) {
    // Checando a sessao
      var restrictedPage = ($location.path() === ''); // verifica se é o index.html
      //console.log(restrictedPage);
      if (!restrictedPage && !$localStorage.currentUser) {
    	$window.location = "/index.html";
      }
    });
  });

 
  