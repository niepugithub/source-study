<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${articleTitle}</title>
</head>
<body>
<pre>
    <h1>welcome to springmvc</h1>
</pre>

${articleTitle}
<hr width="10%" align="left"/>
${article}
<br/><br/>

评论<br/>
${comment}

<h6>RedirectAttributes.addAttribute("addAttribute","addAttribute"):${addAttribute}</h6>
<h6>RedirectAttributes.addFlashAttribute("addFlashAttribute","addFlashAttribute"):${addFlashAttribute}</h6>

</body>
</html>