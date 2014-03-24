    <!--Course name & Author-->
    <div class="row-fluid span12" >
        <div class="container" style="padding-bottom: 10px;">

            <div class="offset1"></div>
            <div class="span5" style="float: left">
            <@spring.formItem "course.name"/>
            </div>

            <div class="span6">
                <label for="course.author.firstName">
                <@spring.message "courses.author"/> </label>
            <@spring.formInput "course.author.firstName" 'class="input-medium"'/>
            <@spring.formInput "course.author.lastName" 'class="input-medium"'/>
            <@spring.showErrors "<br>" />

            </div>
        </div>
    </div>

    <!--Category & Email-->

    <div class="row-fluid span12">
        <div class="container" style="padding-bottom: 10px;">
            <div class="span5">

                <label for="type" style="control-label">
                <@spring.message "courses.category"/>   </label>
            <@spring.bind "categories" />
            <@spring.formSingleSelect "course.type", categories, " "/>

            </div>

            <div class="span6">
            <@spring.formItem "course.author.email"/>
            </div>

        </div>
    </div>

    <!--startDate & Tags-->
    <div class="row-fluid span12">
        <div class="container" style="padding-bottom: 5px;">
            <div class="span5">
            <@spring.formItem "course.startDate" "datepiker" 'class="input-medium"'/>
            </div>

            <div class="span6">
            <@spring.formItem "course.tags" "tags"/>
            </div>
        </div>
    </div>

    <!--endDate-->
    <div class="row-fluid span12">
        <div class="container" style="padding-bottom: 10px;">
            <div class="span5">
            <@spring.formItem "course.endDate" "datepiker" 'class="input-medium"'/>
            </div>
        </div>
    </div>
