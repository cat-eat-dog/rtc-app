package net.github.rtc.app.service.impl;

import net.github.rtc.app.service.DateService;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component("DateService")
public class DateServiceImpl implements DateService {

    @Override
    public Date getCurrentDate() {
        return DateTime.now().toLocalDateTime().toDate();
    }

    @Override
    public Date addDays(Date oldDate, final int days) {
        return new DateTime(oldDate).plusDays(days).toDate();
    }

    @Override
    public int getMothPeriod(final Date startDate, final Date endDate) {
        final Period period = new Period(new DateTime(startDate), new DateTime(endDate), PeriodType.months());
        return period.getMonths();
    }
}