<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function add() {
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            var active = document.getElementById("active").value;
            $.ajax({
                type: 'POST',
                url: "http://localhost:8181/new/add-update",
                contentType: "application/json",
                data: JSON.stringify({
                    "id": null,
                    "categoryId":${categoryId},
                    "title": title,
                    "content": content,
                    "active": active,
                    "createTime": null
                })
            });
            setTimeout(function () {
                location.replace("http://localhost:8181/new/get-news/${categoryId}")
            }, 500)
        }
    </script>
</head>
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

<body>
<div></div>
<div></div><!-- Small modal -->
<a class="btn btn-primary" href='http://localhost:8181/login' type="button" data-target=".bs-example-modal-sm"
   data-toggle="modal">Logout</a>

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
    <div class="form-group">
        <label for="categoryId">categoryId</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" placeholder="categoryId" id="categoryId"
               name="categoryId" value="${categoryId}">
    </div>
    <div class="form-group">
        <label for="name">title</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" <#--placeholder="title"--> id="title" name="title">
    </div>
    <div class="form-group">
        <label for="content">content</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="content"
               name="content" <#--placeholder="content"-->>
    </div>
    <div class="form-group">
        <label for="active">Active</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="active"
               name="active" <#--placeholder="Active" -->>
    </div>

    <a class="btn btn-primary" onclick="add()">Add News</a>
</div>
</body>

</html>


