<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Edit Post</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>
<h1>Edit Post</h1>

<form action="/edit_post/${edit_post.slug}" method="post">

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${edit_post.title}" required><br><br>

    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value="${edit_post.author}" required><br><br>

    <label for="perex">Perex:</label>
    <textarea id="perex" name="perex" required>${edit_post.perex}</textarea><br><br>

    <label for="body">Body:</label>
    <textarea id="body" name="body" required>${edit_post.body}</textarea><br><br>

    <label for="publishedDate">Published Date:</label>
    <input type="date" id="publishedDate" name="publishedDate" value="${edit_post.published?string("yyyy-MM-dd")}" required><br><br>

    <input type="submit" value="Update">
</form>

<a href="/">Back to main page</a>
</body>
</html>
