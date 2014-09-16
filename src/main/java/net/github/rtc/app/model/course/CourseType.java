package net.github.rtc.app.model.course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 7/22/14.
 */
public enum CourseType {
    QA, DEV, BA;

    public static List<String> findAll() {
        List<String> res = new ArrayList<>();
        for (CourseType type : CourseType.values()) {
            res.add(type.name());
        }
        return res;
    }
}
