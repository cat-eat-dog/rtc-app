<h3><@spring.message "news.filter.form.header"/></h3>
<div class="row">
    <div class="col-md-6 form-group">
    <@rtcmacros.formItem "filterNews.title"/>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label class="control-label col-md-2"><@spring.message "news.filterNews.message.created"/></label>
            <@rtcmacros.formSingleSelect "filterNews.dateMoreLessEq",["=", "<", ">"]/>
            <@rtcmacros.formDatepicker "filterNews.createDate"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
    <@rtcmacros.formItem "filterNews.author"/>
    </div>
    <div class="col-md-6">
    <@rtcmacros.formItem "filterNews.status" 'class="input-medium"' "singleSelect" statuses "NewsStatus."/>
    </div>
</div>

<hr/>
<div class="row">
    <div class="col-md-6">
    </div>
    <div class="col-md-5" style="text-align: right">
        <input type="submit" class="btn btn-primary" value="Search"/> or <a
            href="<@spring.url "/admin/news/list" />">Reset</a>
    </div>
</div>
