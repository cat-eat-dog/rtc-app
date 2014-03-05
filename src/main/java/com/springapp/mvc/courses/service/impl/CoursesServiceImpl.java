package com.springapp.mvc.courses.service.impl;

import com.springapp.mvc.courses.dao.CoursesDao;
import com.springapp.mvc.courses.dao.impl.CoursesDaoImpl;
import com.springapp.mvc.courses.model.Courses;
import com.springapp.mvc.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * This is service
 *
 * @author Vladislav Pikus
 */
//Todo May be, need make as component
@Service("coursesService")
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    public void setDao(CoursesDao dao) {
        this.dao = dao;
    }

    private CoursesDao dao;

    @Override
    public Collection<Courses> findAll() {
        return dao.findAll();
    }
}
