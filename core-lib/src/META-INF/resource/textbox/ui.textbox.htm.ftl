<#if label?? && label != ""> <label for="${id}">${label}</label> </#if>
<input class="${cssClass}" type="text" value="${value}" id="${id}" name="${name}" placeholder="${placeholder}" <#if readonly == "Y" > readonly="readonly" </#if> >