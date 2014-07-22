package net.github.rtc.app.service;

import net.github.rtc.app.model.Course;
import net.github.rtc.app.model.CourseDto;
import net.github.rtc.app.model.SearchFilter;

//import com.springapp.mvc.User;

/**
 * Service Interface
 * Provides operations with {@link net.github.rtc.app.model.Course} objects
 *
 * @author Vladislav Pikus
 * @author Dmitry Pritula
 */
public interface CoursesService {

    /**
     * Delete a course by code
     *
     * @param code course code
     * @throws net.github.rtc.app.exception.ServiceProcessingException
     *          if code is null
     */
    void delete(String code);

    /**
     * Find a course object by code
     *
     * @param code course code
     * @return course object
     * @throws net.github.rtc.app.exception.ServiceProcessingException
     *          if code is null
     */
    Course findByCode(String code);

    /**
     * Create a new course object
     *
     * @param course new course object
     * @return course with updated fields
     */
    Course create(Course course);

    /**
     * Update a course object
     *
     * @param course course object for update
     */
    void update(Course course);

    /**
     * Find course collection by filtering param
     *
     * @param filter filter query
     * @return courseDTO
     */
    CourseDto findByFilter(SearchFilter filter);

    /**
     * Set course status as published
     * @param course  what course?
     */
    void publish(Course course);
}
