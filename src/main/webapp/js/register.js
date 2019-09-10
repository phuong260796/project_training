var register = angular.module('register',[]);

register.controller('registerController',function ($scope,$http) {
    $scope.registerFunction = function (inputParam) {
        if (inputParam.password!==inputParam.passwordRepeat){
            alert("mật khẩu bạn nhập không gióng nhau,mời nhập lại ")
        }else {
            $http.post('http://localhost:8181/register-check', inputParam)
                .success(function (resp) {

                    if (resp){
                        console.log(resp);
                        setTimeout(function() {
                            window.location.href = "http://localhost:8181/login";
                        }, 500);
                    }else { alert('trùng tên tài khoản,mời nhập lại!');}
                })
                .error(function () {
                    alert('trùng tên tài khoản,mời nhập lại!');
                });
        }

    };
});