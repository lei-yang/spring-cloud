<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
</head>
<body>
<h1>菜单列表</h1>
${result!""}
<#if wxMpMenu?has_content >
    菜单:<br>
    <#if wxMpMenu.menu?has_content && wxMpMenu.menu.buttons?exists&& wxMpMenu.menu.buttons?size gt 0>
        <#list wxMpMenu.menu.buttons as button>
            类型:${button.type!''}
            名称:${button.name!''}
            key:${button.key!''}
            url:${button.url!''}
            <br>
            子菜单:<br>
            <#if button?has_content && button.subButtons?exists&& button.subButtons?size gt 0>
                <#list button.subButtons as subButtons>
                    类型:${subButtons.type!''}
                    名称:${subButtons.name!''}
                    key:${subButtons.key!''}
                    url:${subButtons.url!''}
                    <br>
                </#list>
            </#if>
            <br><br>
        </#list>
    </#if>
</#if>
</body>
</html>