[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Add New Post</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>
<h1>Add New Post</h1>
<form action="/new" method="post">
    <label for="slug">Slug:</label>
    <input type="text" id="slug" name="slug" required><br><br>

    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required><br><br>

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>

    <label for="perex">Perex:</label>
    <textarea id="perex" name="perex" required></textarea><br><br>

    <label for="body">Body:</label>
    <textarea id="body" name="body" required></textarea><br><br>

    <label for="publishedDate">Published Date:</label>
    <input type="date" id="publishedDate" name="publishedDate" required><br><br>

    <input type="submit" value="Save">
</form>
<a href="/">Back to main page</a>
</body>
</html>
