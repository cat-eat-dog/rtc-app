<html>
<#include "macro.ftl">
<#import "/spring.ftl" as spring/>
<head>
<#include "link.ftl">
</head>

<title><@spring.message "register"/></title>

<body>

<div id="content">

<h1><@spring.message "register"/></h1><br>


<!--  The form that will be parsed by jQuery before submit  -->
<form name="userForm" action="viewPage" method="post" id="register-form" novalidate="novalidate">

    <div class="row-fluid">
        <div class="span12">

        <!--name & birth row-->
        <div class="row-fluid">

        <div class="span5">

            <div class="label"> <@spring.message "reg.firstName"/></div><br>

                  <input type="text" id="firstname" name="firstname" /> <br>

            <div class="label"><@spring.message "reg.lastName"/></div>  <br>
            <input type="text" id="lastname" name="lastname" />

            <div class="label"><@spring.message "town"/>

                <div class="label"><@spring.message "phone"/>

                    <div class="label"><@spring.message "reg.email"/>

                                </div></div></div> <br>

            <input type="text" id="town" name="town" />
             <input type="text" id="phone" name="phone" />
                <input type="text" id="email" name="email" />

                                                                                     </div>
            <div class="span5">
        <div class="label"><@spring.message "reg.birthDate"/> </div>
            <input type="text" id="birthYear" name="birthYear" />
        </div>


                                                                            </div>
    <!--end of name/lastname & birth block-->

       <hr/>

            <div class="label"><@spring.message "reg.password"/></div><br>
            <input type="password" id="password" name="password" /><br />

    <div style="margin-left:140px;"> <input class ="btn btn-warning" type="submit" name="submit" value=<@spring.message "reg.register"/> > </div>


</div>

        <!--Closing all hell-table -->
        </div>

</form>

</div>

</body>
</html>
