<form name="course" id="course" action="<@spring.url "/admin/courses/save" />" method="post">

    <h3 class="page-header"><@spring.message "create.message"/></h3>
            <#include "courseForm.ftl" />

                <!--Create & Cancel-->
                <div class="row-fluid span12">
                        <div class="span6">
                        </div>

                        <div class="span5" style="text-align: right">

                            <input type="submit" class="btn" value="Create"/> or <a
                                href="<@spring.url "/admin/courses" />">Cancel</a>

                        </div>
                </div>
</form>
