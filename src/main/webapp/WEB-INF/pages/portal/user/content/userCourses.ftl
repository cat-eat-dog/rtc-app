<div class="row-fluid 12">
    <div class="span2">
        <label>My courses</label>
    </div>
</div>

<hr size="2">
<div class="">
    <div class="span12">
        <label>Available courses</label>
    </div>
    <div class="container" style="margin-left: -20px;padding-right: 0px">
    <#list courses as course>
        <div class="span4"
             style="word-wrap: break-word; border: solid 1px #008000;text-align: center;margin-top:10px; margin-left: 5px;">
            <a href="<@spring.url'/user/courseDetails/${course.code}'/>">${course.name} </a>
            <br>

            <div class="thumbnail">
                <img src="<@spring.url'/resources/images/profile.jpg'/>"
                     alt="..." style="width: 200px;height: 120px">
            </div>
            <br>

            <div class="userCourses"> ${course.description}</div>
            <br>
            <div class="btn btn-success" id="${course.code}"
                 style="margin-bottom: 5px "
                 onClick='setCode(this.id);javascript:PopUpShow("${course.types?join(',')}")'> Apply
            </div>
        </div>
    </#list>
    </div>

</div>


<div class="popup" id="window-popup" style="display: none">
    <div class="popup-content">
        <center>
            <h2><@spring.message "userCourses"/></h2>
        </center>
        <strong>
        <@spring.message "userCourses.IHave"/>  <@spring.message "userCourses.IHave2"/>
        </strong>

        <form name="modal" action="sendOrder" method="post">
            <input name="selectedCode" type="hidden" id="selectedCode"
                   value="test">

            <div id="Development">
            <input type="radio" name="userCourses" id="Development"
                   value="<@spring.message "userCourses.developer"/>"  />
            <@spring.message "userCourses.developer"/></label><br/>
            </div>

            <div id="Quality Assurance">
            <input type="radio" name="userCourses" id="Quality Assurance"
                   value="<@spring.message "userCourses.tester"/>"/>
            <@spring.message "userCourses.tester"/></label><br/>
            </div>

            <div id="Business Analysis">
            <input type="radio" name="userCourses" id="Business Analysiss"
                   value="<@spring.message "userCourses.Business_Analyst"/>"/>
            <@spring.message "userCourses.Business_Analyst"/></label><br/>
            </div>

            <strong><@spring.message "userCourses.because"/></strong><br/>

            <textarea class="input-block-level" name="userTextArea" id="redex"
                      rows="10" cols="55"></textarea><br>
            <style type="text/css">#redex {
                resize: none;
            }</style>
            <br/>
            <center>
                <button class="btn" onclick="pushData()">Ok</button>
                <button class="btn" type="button"
                        onClick="javascript:PopUpHide()">Cancel
                </button>
            </center>
        </form>

    </div>
</div>

<script type="text/javascript">
    function PopUpShow(types) {
        types.split(",").forEach(function(type){
            $("#"+type).show()
        })
        $("#window-popup").show();
    }
    function PopUpHide() {
        $("#window-popup").hide();
    }
</script>


<script type="text/javascript">
    var selectedCourseCode
    function setCode(courseCode) {
        document.getElementById("selectedCode").value = courseCode
    }
    function pushData() {
        $.ajax({
            type: 'POST',
            url: "/sendOrder",
            data: selectedCourseCode
        });
    }
</script>
