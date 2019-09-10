<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script>
        function search() {
            var valueImput = document.getElementById("paramSearch").value;
            window.location = "http://localhost:8181/check-log/" + valueImput;
        }
    </script>
</head>
<style>

    .table-wrapper {
        background: #fff;
        padding: 20px;
        margin: 30px 0;
        box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
    }

    .table-title {
        padding-bottom: 10px;
        margin: 0 0 10px;
    }

    .table-title h2 {
        margin: 8px 0 0;
        font-size: 22px;
    }

    .search-box {
        position: relative;
        float: right;
    }

    .search-box input {
        height: 34px;
        border-radius: 20px;
        padding-left: 35px;
        border-color: #ddd;
        box-shadow: none;
    }

    .search-box input:focus {
        border-color: #3FBAE4;
    }

    .search-box i {
        color: #a0a5b1;
        position: absolute;
        font-size: 19px;
        top: 8px;
        left: 10px;
    }

    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
    }

    table.table-striped tbody tr:nth-of-type(odd) {
        background-color: #fcfcfc;
    }

    table.table-striped.table-hover tbody tr:hover {
        background: #f5f5f5;
    }

    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }

    table.table td:last-child {
        width: 130px;
    }

    table.table td a {
        color: #a0a5b1;
        display: inline-block;
        margin: 0 5px;
    }

    table.table td a.view {
        color: #03A9F4;
    }

    table.table td a.edit {
        color: #FFC107;
    }

    table.table td a.delete {
        color: #E34724;
    }

    table.table td i {
        font-size: 19px;
    }

    .pagination {
        float: right;
        margin: 0 0 5px;
    }

    .pagination li a {
        border: none;
        font-size: 95%;
        width: 30px;
        height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 30px !important;
        text-align: center;
        padding: 0;
    }

    .pagination li a:hover {
        color: #666;
    }

    .pagination li.active a {
        background: #03A9F4;
    }

    .pagination li.active a:hover {
        background: #0397d6;
    }

    .pagination li.disabled i {
        color: #ccc;
    }

    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }

    .hint-text {
        float: left;
        margin-top: 6px;
        font-size: 95%;
    }

</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<body>
<div class="container">
    <div class="table-wrapper">

        <div class="form-inline">
            <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
                   id="paramSearch" name="customerName" value="${(inputSearch)!}" placeholder="imput search"/>

            <button type="submit" onclick="search()" class="btn btn-primary" style="margin:15px;">Search</button>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>id</th>
                    <th>computerName <i class="fa fa-sort"></i></th>
                    <th>userWindow</th>
                    <th>userName <i class="fa fa-sort"></i></th>
                    <th>ActionDescription</th>
                    <th>formAction <i class="fa fa-sort"></i></th>
                    <th>timeAction</th>
                </tr>
                </thead>
                <#list log as log>
                    <tbody>
                    <tr>
                        <td>${(log.id)!}</td>
                        <td>${(log.computerName)!}</td>
                        <td>${(log.userWindow)!}</td>
                        <td>${(log.userName)!}</td>
                        <td>${(log.actionDescription)!}</td>
                        <td>${(log.formAction)!}</td>
                        <td>${(log.timeAction)!}</td>
                    </tr>
                    </tbody>
                </#list>
            </table>

        </div>
    </div>
</body>

</html>


