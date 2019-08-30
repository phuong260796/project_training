<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function timeConverter(UNIX_timestamp) {
            var a = new Date(UNIX_timestamp * 1000);
            var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
            var year = a.getFullYear();
            var month = months[a.getMonth()];
            var date = a.getDate();
            var hour = a.getHours();
            var min = a.getMinutes();
            var sec = a.getSeconds();
            var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec;

            return time;
        }

        function updateNews() {
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            var active = document.getElementById("active").value;
            // var create = document.getElementById("createTime").value;
            $.ajax({
                type: 'POST',
                url: "http://localhost:8181/new/add-update",
                contentType: "application/json",
                data: JSON.stringify({
                    "id":${updateNews.id},
                    "categoryId":${updateNews.categoryId},
                    "title": title,
                    "content": content,
                    "active": active,
                    "create": null
                })
            });
            setTimeout(function () {
                location.replace("http://localhost:8181/new/get-news/${updateNews.categoryId}")
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
<div class="container">
    <div class="form-group">
        <label for="name">title</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" placeholder="title" id="title"
               value="${updateNews.title}" name="title">
    </div>
    <div class="form-group">
        <label for="content">content</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="content" name="content" placeholder="content"
               value="${updateNews.content}">
    </div>
    <div class="form-group">
        <label for="active">Active</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="active" name="active" placeholder="Active"
               value="${updateNews.active}">
    </div>
    <#--  <div class="form-group">
          <label for="createTime">create time</label>

          <input type="da" class="form-control mb-2 mr-sm-2 mb-sm-0" id="createTime" name="createTime" placeholder="createTime"  value="${updateNews.createTime}">
      </div>-->
    <a class="btn btn-primary updateNews-id1" onclick="updateNews()">Update</a>
</div>
</body>

</html>


