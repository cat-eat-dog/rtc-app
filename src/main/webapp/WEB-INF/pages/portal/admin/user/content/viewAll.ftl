<h3 class="page-header"><@spring.message "user.list"/></h3>


<@spring.addPagination "/admin/user/viewAll/" />
<table width="100%" class="table-bordered table" id="data">
    <tr bgcolor="#d3d3d3" style="font-weight:bold">
        <td>Name</td>
        <td>Email</td>
        <td>Phone</td>
        <td>Register Date</td>
        <td>Role</td>
        <td>Status</td>
        <td>Action</td>
    </tr>
<#list users as user>
    <tr>
        <#if (user.name) ?? && (user.surname) ?? >
            <td>
                <a href="<@spring.url"/admin/user/userPage/${user.code}"/>">  ${user.surname + " " + user.name } </a>
            </td>
        <#else>
            <td>None</td>
        </#if>

        <#if (user.email)??>
            <td>${user.email}</td>
        <#else>
            <td>None</td>
        </#if>

        <#if (user.phone)??>
            <td>${user.phone}</td>
        <#else>
            <td>None</td>
        </#if>

        <#if (user.registerDate)??>
            <td>${user.registerDate?datetime?string("dd-MM-yyyy")}</td>
        <#else>
            <td>None</td>
        </#if>

        <td>
            <#list user.authorities as role>
            ${role}<#if role_has_next>,</#if>
            </#list>
        </td>

        <#if (user.status)??>
            <td>${user.status}</td>
        <#else>
            <td>None</td>
        </#if>
        <td>
            <#if user.isForRemoval() >
                <form style="margin: 0 0 0" name="deleteUser" action="<@spring.url"/admin/user/restore/"/>" method="post">
                    <input type="hidden" name="userCode" value="${user.code}"/>
                    <button class="btn" type="submit">Restore</button>
                </form>
            <#else>
                <button class="btn" onclick="javascript:PopUpShow('${user.code}')">Remove</button>
            </#if>
        </td>
    </tr>
</#list>
</table>

<div class="popup " id="window-popup" style="display: none">
    <div class="popup-content">
        <center>
            <h2>Remove</h2>
        </center>
        <center>
            <lable>Do you realy want to remove specified user?</lable>
        </center>
        <br>
        <center>
            <form name="deleteUser" action="<@spring.url"/admin/user/remove/"/>" method="post">
                <input type="hidden" id="userCode" name="userCode"/>
                <button class="btn" type="submit">Ok</button>
                <button class="btn" type="button" onClick="javascript:PopUpHide()">Cancel</button>
            </form>
        </center>
    </div>
</div>

<br><br><br>

<div align="right">
    <form name="createUser" action="<@spring.url"/admin/user/createUser"/>"method="get">
        <button class="btn" type="submit">Create New</button>
    </form>
</div>

<script type="text/javascript">
//	$(document).ready(function () {
//		PopUpHide();
//	});
    function PopUpShow(userCode) {
        $("#userCode").val(userCode);
        $("#window-popup").show();
    }
    function PopUpHide() {
        $("#window-popup").hide();
    }
</script>
