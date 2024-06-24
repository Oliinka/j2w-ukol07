[#ftl]
[#import '_imports/common.ftlh' as c]
[@c.page]


<h1>MY BLOG</h1>
<a href="/new">Add new article</a>

<table>
    <thead>
    <tr>
        <th>Slug</th>
        <th>Author</th>
        <th>Perex</th>

        <th>Published</th>
    </tr>
    </thead>
    <tbody>
    [#list posts as post ]
        <tr>
            <td>${post.title}</td>
            <td>${post.author}</td>
            <td>${post.perex}</td>

            <td>${post.published}</td>
            <td class="read-button"><a href="/post/${post.slug}">READ</a></td>
            <td class="read-button"><a href="/edit_post/${post.slug}">EDIT</a></td>
        </tr>
    [/#list]
    </tbody>
</table>

[/@c.page]
