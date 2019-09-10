
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../css/index.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script src="../js/index.js"></script>
    <script src="../js/ModalCategory.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link data-require="bootstrap@3.3.7" data-semver="3.3.7" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link data-require="bootstrap-css@3.*" data-semver="3.3.7" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" />
    <script data-require="angular.js@1.6.5" data-semver="1.6.5" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
    <script data-require="angular-animate@1.6.*" data-semver="1.6.5" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular-animate.min.js"></script>
    <script data-require="angular-touch@1.6.*" data-semver="1.6.2" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular-touch.js"></script>
    <script data-require="ui-bootstrap@*" data-semver="2.5.0" src="https://cdn.rawgit.com/angular-ui/bootstrap/gh-pages/ui-bootstrap-tpls-2.5.0.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini" ng-app="index">
<div class="wrapper" ng-controller="ModalController">
    <header class="main-header">
        <a href="http://localhost:8181" class="logo">
            <span class="logo-lg"><b>CHIPO</b></span>
        </a>
        <nav class="navbar navbar-static-top">
<#--            <div class="navbar-custom-menu">-->
<#--                <ul class="nav navbar-nav">-->
<#--                    <li class="dropdown user user-menu">-->
<#--                        <a href="http://localhost:8181/register" class="dropdown-toggle" data-toggle="dropdown">-->
<#--                            <span style="margin: auto" class="hidden-xs">Đăng xuất</span>-->
<#--                        </a>-->
<#--                    </li>-->
<#--                </ul>-->
<#--            </div>-->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="http://localhost:8181/login" class="dropdown-toggle" data-toggle="dropdown">
                            <span style="margin: auto" class="hidden-xs">Đăng xuất</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <aside class="main-sidebar">D
        <section class="sidebar">
            <div class="user-panel">
                <div class="pull-left ">
                    <img   >
                </div>
                <div class="pull-left info">
                    <p>Menu</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <ul class="sidebar-menu">
                <li class="active ">
                    <a href="#">
                        <i class="fa " type="button"></i> <span>Check log</span> <i class="fa  "></i>
                    </a>
                </li>
            </ul>
            <ul class="sidebar-menu">
                <li class="active ">
                    <a href="#">
                        <i class="fa " type="button"></i> <span>Category News</span> <i class="fa  "></i>
                    </a>
                </li>
            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                CHIPO
                <small>cổng nhập hàng Trung Quốc tận gốc uy tín, giá rẻ</small>
            </h1>
<#--            <ol class="breadcrumb">-->
<#--                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>-->
<#--            </ol>-->
        </section>
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Category News</h3>
                        </div>
                        <div class="box-body">
                            <button class="btn btn-info" ng-click="addCategory()" style="margin: 15px;"> Add Category News</button>
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Category Name</th>
                                        <th>Update</th>
                                        <th>Delete</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list categoryNews as category>
                                    <tr>
                                        <td><a  href="">${(category.name)!}</a></td>
                                        <td><a ng-click="updateCategory(${category.id})"   role="button">Update ${(category.name)!}</a></td>
                                        <td><a ng-click="deleteCatego(${category.id})" role="button">Delete ${(category.name)!}</a></td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
</div>
</section>
</div>

<footer class="main-footer">
    <strong>Chipo cổng nhập hàng Trung Quốc tận gốc uy tín</strong><br>
    <strong>Address: Số 18 Tam Trinh, Hai Bà Trưng, Hà Nội</strong><br>
    <strong>Hotline: 1900.633.432</strong><br>
    <strong>Email: hotro@chipo.vn</strong>
</footer>
<div class="control-sidebar-bg"></div>
</div>
</body>
</html>
