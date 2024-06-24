[#ftl]
[#import '_imports/common.ftlh' as c]
[@c.page]

[#list posts as post]
    <h1>${post.title}</h1>
    <p><strong>Autor:</strong> ${post.author}</p>
    <p><strong>Date:</strong> ${post.published}</p>
    <p>${post.body}</p>
[/#list]
<a href="/">Back to the main page</a>


[/@c.page]