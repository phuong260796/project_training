<!DOCTYPE html>
<html lang="en">
<head>
    <#--    <link href="static/css/bootstrap.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
                    url: "http://localhost:8181/category/delete",
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
                url: "http://localhost:8181/category/add-update",
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

<div class="container">

    <div class="form-inline">
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"
               id="customerName" name="customerName" placeholder="Tên danh mục"/>

        <button type="submit" onclick="add()" class="btn btn-primary" style="margin:15px;">Add News</button>

        <#--        <button type="submit" class="btn btn-primary">Update</button>-->

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
            <tr class="deletes-${categoryNew[0]}">
                <td><a href='http://localhost:8181/new/get-news/${categoryNew[0]}'>${categoryNew[1]}</a></td>
                <td><a class="btn btn-sm btn-warning delete-${categoryNew[0]}"
                       onclick="deleteCategory(${categoryNew[0]})" role="button" category-name="${categoryNew[1]}"
                    >Delete</a></td>
                <td><a class="btn btn-sm btn-warning"
                       href='http://localhost:8181/category/updatedetail/${categoryNew[0]}' role="button">Update</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>


