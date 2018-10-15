<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarker</title>
</head>
<body>
hello ${say!''}<br>
<img src="${userInfo.headImgUrl!''}"/><br>
昵称:${userInfo.nickname!''}<br>
性别:
<#if userInfo.sex == 1>
男
<#elseif userInfo.sex == 2>
女
<#else>
其他
</#if>
<br>
国家:${userInfo.country!''}<br>
省份:${userInfo.province!''}<br>
城市:${userInfo.city!''}<br>
${userInfo.openId!''}
</body>
</html>