var app = angular.module('index', ['ui.bootstrap']);

app.controller('ModalController', function ($scope, $uibModal, $http) {
    $scope.addCategory = function () {
        var modalInstance = $uibModal.open({
            templateUrl: "http://localhost:8181/htmlviews/ModalAddCategory.html",
            controller: "ModalAddCategory",
            size: '',
        });
    };
    $scope.updateCategory = function (id) {
        $http.get('http://localhost:8181/updatedetail/' + id)
            .success(function (resp) {
                $scope.dataResp = resp;
                $uibModal.open({
                    templateUrl: "http://localhost:8181/htmlviews/ModalUpdateCategory.html",
                    controller: "ModalUpdateCategory",
                    scope: $scope,
                    size: '',
                });
            });
    };

    $scope.deleteCatego = function (id) {
        $http.get('http://localhost:8181/check-delete/' + id)
            .success(function (resp) {
                // $scope.dataResp = resp;
                var dataDelete = {
                    qtyNews:resp,
                    categoryId:id
                }
                $scope.dataResp = dataDelete;
                    $uibModal.open({
                    templateUrl: "http://localhost:8181/htmlviews/ModalDeleteCategory.html",
                    controller: "ModalDeleteCategory",
                    scope: $scope,
                    size: '',
                });
            });
    };
});

app.controller('ModalDeleteCategory', function ($scope, $uibModalInstance, $http) {
    $scope.dataRespone = $scope.dataResp;
    console.log($scope.dataResp);
    $scope.delete = function () {
        $http.post('http://localhost:8181/delete/'+$scope.dataRespone.categoryId,null)
            .success(function () {
                setTimeout(function () {
                    location.reload();
                }, 200)
            })
        $uibModalInstance.close("Ok");
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    }
});

app.controller('ModalUpdateCategory', function ($scope, $uibModalInstance, $http) {
    $scope.dataRespone = $scope.dataResp;
    $scope.submit = function () {
        $http.post('http://localhost:8181/add-update', $scope.dataRespone)
            .success(function () {
                setTimeout(function () {
                    location.reload();
                }, 200)
            })
        $uibModalInstance.close("Ok");
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    }
});

app.controller('ModalAddCategory', function ($scope, $uibModalInstance, $http) {
    $scope.ok = function (inputParam) {
        var data = {
            id: null,
            name: inputParam,
            active: "Y"
        };
        $http.post('http://localhost:8181/add-update', data)
            .success(function () {
                setTimeout(function () {
                    location.reload();
                }, 200)
            })
            .error(function () {
                alert('trùng tên tài khoản mời nhập lại!');
            });
        $uibModalInstance.close("Ok");
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    }

});