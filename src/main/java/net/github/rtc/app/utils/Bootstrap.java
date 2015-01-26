package net.github.rtc.app.utils;

import net.github.rtc.app.model.activity.Activity;
import net.github.rtc.app.model.activity.ActivityAction;
import net.github.rtc.app.model.activity.ActivityEntity;
import net.github.rtc.app.model.user.RoleType;
import net.github.rtc.app.model.user.User;
import net.github.rtc.app.model.user.UserStatus;
import net.github.rtc.app.service.ActivityService;
import net.github.rtc.app.service.DateService;
import net.github.rtc.app.service.UserService;
import org.jasypt.hibernate4.encryptor.HibernatePBEStringEncryptor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

@Component
@DependsOn("allowEncryptionWithoutJCE")
public class Bootstrap implements InitializingBean {

    private static final String STRING_ADMIN = "admin";
    private static final String ADMIN_EMAIL = "admin@email.com";
    @Autowired
    private HibernatePBEStringEncryptor hibernateStringEncryptor;
    @Autowired
    private UserService userService;
    @Autowired
    private DateService dateService;
    @Autowired
    private ActivityService activityService;

    public void loadTestUsers() {
        if (userService.loadUserByUsername(ADMIN_EMAIL) == null) {
            if (userService.getRoleByType(RoleType.ROLE_ADMIN) == null) {
                userService.createRole(RoleType.ROLE_ADMIN);
            }
            if (userService.getRoleByType(RoleType.ROLE_USER) == null) {
                userService.createRole(RoleType.ROLE_USER);
            }
            if (userService.getRoleByType(RoleType.ROLE_EXPERT) == null) {
                userService.createRole(RoleType.ROLE_EXPERT);
            }

            final User admin = new User("TestName", "TestMiddlename", "TestSurname", ADMIN_EMAIL, STRING_ADMIN);
            admin.setAuthorities(Arrays.asList(userService.getRoleByType(RoleType.ROLE_ADMIN)));
            admin.setRegisterDate(dateService.getCurrentDate());
            admin.setGender("Male");
            admin.setPhone("123456");
            admin.setNote("note");
            admin.setBirthDate(dateService.getCurrentDate());
            admin.setStatus(UserStatus.ACTIVE);
            admin.setEnglish("eng");
            userService.create(admin);
        }
    }

    
//    public void loadTestActivities() {
//        if (activityService.findAll().size() == 0) {
//            Date date1 = new Date(114, 8, 23);
//            Date date2 = new Date(115, 1, 3);
//            Date date3 = new Date();
//            Activity activity1 = new Activity();
//            activity1.setAction(ActivityAction.SAVED);
//            activity1.setActionDate(date1);
//            activity1.setDetail("sdf");
//            activity1.setEntity(ActivityEntity.COURSE);
//            activity1.setUsername("vasya");
//            Activity activity2 = new Activity();
//            activity2.setAction(ActivityAction.REMOVED);
//            activity2.setActionDate(date2);
//            activity2.setDetail("sdfewr");
//            activity2.setEntity(ActivityEntity.USER);
//            activity2.setUsername("petya");
//            Activity activity3 = new Activity();
//            activity3.setAction(ActivityAction.UPDATED);
//            activity3.setActionDate(date3);
//            activity3.setDetail("sdqwerf");
//            activity3.setEntity(ActivityEntity.NEWS);
//            activity3.setUsername("kostya");
//            activityService.create(activity1);
//            activityService.create(activity2);
//            activityService.create(activity3);
//        }
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadTestUsers();
//        loadTestActivities();
    }
}
