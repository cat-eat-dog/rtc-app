<html>

<head>
<#--<#assign security=JspTaglibs["http://www.springframework.org/security/tag"]/>-->
  <title>User Page</title>
 </head>

<body>

    <p1>User Details</p1>
        <br>
        <br>

   <div class="row-fluid 12">
        <div class="span3" style="margin-left: 95px">

            <label>Email: ${user.email!" "}</label>

        </div>
         <br>
          <br>
       <div class="span3" style="margin-left: 100px">

           <label>Role:
               <#list user.authorities as role>
                ${role}<#if role_has_next>,</#if>
               </#list>
           </label>

       </div>

   </div>

        <hr>

   <div class="row-fluid 12">

        <div class="span12" style="margin-left: 80px">
            <label>Gender: ${user.gender!" "}</label>

            <br>

            <div class="span3" style="margin-left: -15px">
            <label>Last Name: ${user.surname!" "}</label>
            </div>
            <div class="span7" style="margin-left: 180px">
            <label>First Name: ${user.name!" "}</label>
            </div>

        </div>


       <div class="span12" style="margin-left: 80px">
    <br>
           <div class="span3" style="margin-left: -30px">
               <label>Middle Name: ${user.middleName!" "}</label>
           </div>
           <div class="span7" style="margin-left: 200px">
               <label>BirthDate: <#if user.birthDate??>${user.birthDate ? datetime ? string("yyyy-MM-dd")}</#if></label>
           </div>

       </div>

   </div>

        <hr>

            <div class="row-fluid 12">

                <div class="span12" style="margin-left: 80px">
                <div class="span3" style="margin-left: 25px">
                    <label>City:${user.city!" "}</label>
                </div>
                <div class="span7" style="margin-left: 165px">
                    <label>Phone: ${user.phone!" "}</label>
                </div>
        </div>
            </div>

        <hr>

    <div class="row-fluid 12">

        <div class="span12" style="margin-left: 80px">
            <div class="span3" style="margin-left: -15px">
                <label>Univercity: ${user.university!" "}</label>
            </div>
            <div class="span7" style="margin-left: 180px">
                <label>Speciality: ${user.speciality!" "}</label>
            </div>

            <div class="span3" style="margin-left: 0px">
                <br>
                <label>Faculty: ${user.faculty!" "}</label>
            </div>
        </div>

    </div>

        <hr>


    <div class="row-fluid 12">

        <div class="span12" style="margin-left: 80px">
            <div class="span7" style="margin-left: -105px">
                <label>Programming languages:
                    <#list user.programmingLanguages as progLang>
                        ${progLang}<#if progLang_has_next>,</#if>
                    </#list>
                </label>
            </div>
            <div class="span3" style="margin-left: -70px">
                <label>English: ${user.english!" "}</label>
            </div>
        </div>
    </div>

        <hr>

        <div class="row-fluid 12">

            <div class="span12" style="margin-left: -35px">

                <label>Why do you want to join us: ${user.note!" "}</label>

            </div>


        </div>

        <hr>
    <div class="row-fluid">
        <div class="span10"></div>
<div class="span1" style="text-align: right">


    <form name ="editPage" action="editPage/${user.code}" method="get">
    <button class="btn" type="submit"   >Edit</button>
    </form>

    </div>
        <div class="span1" style="margin-left: -2px;text-align: right">
             or
    <a href="<@spring.url "/admin/user/viewAll" />">Cancel</a>

    </div>
</div>
    </div>
</body>

</html>