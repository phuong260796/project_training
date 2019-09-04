<!DOCTYPE html>
<html lang="en">
<head>
    <#--    <link href="static/css/bootstrap.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        .container {
            margin-top: 80px;
        }

        .bg-dark {
            background-color: #3b8dbd !important;
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function deleteCategory(id) {
            var cateName = $(".delete-" + id).attr("category-name");
            if (confirm("Bạn có muốn xóa không ?")) {
                $.ajax({
                    type: 'POST',
                    url: "http://localhost:8181/delete",
                    contentType: "application/json",
                    data: JSON.stringify({"name": cateName, "id": id, "active": "N"})
                });
                $.ajax({
                    url: "test.html",
                    context: document.body
                }).done(function () {
                    $(this).addClass("done");
                });
                $(".deletes-" + id).css("display", "none");
            }
        }


        function add() {
            var valueImput = document.getElementById("customerName").value;
            $.ajax({
                type: 'POST',
                url: "http://localhost:8181/add-update",
                contentType: "application/json",
                data: JSON.stringify({"name": valueImput, "id": null, "active": "Y"})
            });
            setTimeout(function () {
                location.reload();
            }, 500)
        }
    </script>
</head>
<body>
<div></div><div></div><!-- Small modal -->
<a class="btn btn-primary" href='http://localhost:8181/login' type="button" data-target=".bs-example-modal-sm" data-toggle="modal">Logout</a>

<div tabindex="-1" class="modal bs-example-modal-sm" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header"><h4>Logout <i class="fa fa-lock"></i></h4></div>
            <div class="modal-body"><i class="fa fa-question-circle"></i> Are you sure you want to log-off?</div>
            <div class="modal-footer"><a class="btn btn-primary btn-block" href="javascript:;">Logout</a></div>
        </div>
    </div>
</div>

<div class="container">

    <div class="form-inline">
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
               id="customerName" name="customerName" placeholder="Tên danh mục"/>

        <button type="submit" onclick="add()" class="btn btn-primary" style="margin:15px;">Add News</button>

        <#--        <button type="submit" class="btn btn-primary">Update</button>-->

    </div>
    <br/>
    <div class="form-inline">
        <a type="button" href='http://localhost:8181/check-log'  class="btn btn-primary" style="margin:15px;">Check log</a>
    </div>
    <br/>
    <table class="table">
        <thead>
        <tr>
            <th>Danh mục sản phẩm</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list categoryNews as categoryNew>
            <tr class="deletes-${categoryNew.id}">
                <td><a href='http://localhost:8181/new/get-news/${categoryNew.id}'>${categoryNew.name}</a></td>
                <td><a class="btn btn-sm btn-warning delete-${categoryNew.id}"
                       onclick="deleteCategory(${categoryNew.id})" role="button" category-name="${categoryNew.name}"
                    >Delete</a></td>
                <td><a class="btn btn-sm btn-warning"
                       href='http://localhost:8181/updatedetail/${categoryNew.id}' role="button">Update</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</div>
</body>
</html>


