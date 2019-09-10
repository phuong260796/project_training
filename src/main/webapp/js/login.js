var login = angular.module('login',[]);

login.controller('loginController',function ($scope,$http) {
    $scope.loginFunction = function (inputParam) {
        $http.post('http://localhost:8181/check-login', inputParam)
            .success(function (resp) {
                if (resp){



                    setTimeout(function() {
                        window.location.href = "http://localhost:8181";
                    }, 500);
                }else { alert('sai tai khoan hoac mat khau!');}
            })
            .error(function () {
                alert('sai tai khoan hoac mat khau!');
            });
    };

});