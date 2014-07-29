package net.github.rtc.app.export;

import net.github.rtc.app.model.user.User;
import net.github.rtc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Ivan Yatcuba on 7/29/14.
 */

@Component
public class UserExportTask {
    @Autowired
    private UserService userService;
    @Value("${user.export.path}")
    private String filePath;

    public void exportData() {
        XLSXReportBuilder reportBuilder = new XLSXReportBuilder();
        reportBuilder.build(User.class, userService.findAll(), "users", filePath);
    }
}
