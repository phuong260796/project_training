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
        function Updatedata(id) {
            console.log("dsafsda");
            var name = document.getElementById("name").value;
            var active = document.getElementById("active").value;
            $.ajax({
                type: 'POST',
                url: "http://localhost:8181/category/add-update",
                contentType: "application/json",
                data: JSON.stringify({"name": name, "id": id, "active": active})
            });
            setTimeout(function () {
                location.replace("http://localhost:8181/category/index")
            }, 500)
        }
    </script>
<body>
<div class="container">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" placeholder="name" id="name"
               value="${categoryNews.name}" name="name">
    </div>
    <div class="form-group">
        <label for="active">Active</label>
        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="active" name="active" placeholder="Active"
               value="${categoryNews.active}">
    </div>
    <button type="submit" onclick="Updatedata(${categoryNews.id})" class="btn btn-primary">Update</button>
</div>
</body>
</html>


