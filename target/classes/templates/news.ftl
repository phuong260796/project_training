<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script>
        var date = new Date(unix_timestamp * 1000);

        function deleteNews(id) {
            if (confirm("Bạn có muốn xóa không ?")) {
                console.log(id);
                $.ajax({
                    type: 'POST',
                    url: "http://localhost:8181/new/delete/" + id,
                    contentType: "application/json"
                });
                setTimeout(function () {
                    location.reload();
                }, 500)
            }
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
    <label for="table">
        <td><a class="btn btn-primary" href='http://localhost:8181/new/add-news/${categoryId}'
               style=" display: block;
                  margin-left: auto;
                  margin-right: auto;"
               role="button">Add News</a></td>
    </label>
    <table class="table">
        <thead>
        <label for="table">
            <td><a class="btn btn-primary bg-dark" href='http://localhost:8181'
                   style=" display: block;
                  margin-left: auto;
                  margin-right: auto;"
                   role="button">${name}</a></td>
        </label>
        <tr>
            <th>title</th>
            <th>content</th>
            <th>active</th>
            <th>createTime</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list news as news>
            <tr>
                <td>${news.title}</td>
                <td>${news.content}</td>
                <td>${news.active}</td>
                <td>${news.createTime}</td>
                <td><a class="btn btn-sm btn-warning delete-${news.id}" onclick="deleteNews(${news.id})"
                       createTime="${news.createTime}" role="button">Delete</a></td>
                <td><a class="btn btn-sm btn-warning" href='http://localhost:8181/new/updatenewsdetail/${news.id}'
                       role="button">Update</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>


