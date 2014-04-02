<html>
<#import "/spring.ftl" as spring/>

<head>
    <#include "courses/layout/link.ftl">

</head>

<body>

    <#include "courses/layout/header.ftl">

    <div class="container-fluid" style="margin-bottom: 60px">
        <div class="row">
            <#include "courses/layout/menu.ftl">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                   

                <#include "${content}.ftl">
               
            </div>
        </div>
    </div>

    <#include "courses/layout/footer.ftl">

</body>

</html>




