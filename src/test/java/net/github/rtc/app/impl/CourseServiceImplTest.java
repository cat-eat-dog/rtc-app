package net.github.rtc.app.impl;

import net.github.rtc.app.exception.ServiceProcessingException;
import net.github.rtc.app.model.course.Course;
import net.github.rtc.app.resource.CoursesResource;
import net.github.rtc.app.resource.impl.CoursesResourceImpl;
import net.github.rtc.app.service.CourseService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Vladislav Pikus
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mvc-test.xml" })
@Ignore
public class CourseServiceImplTest {

    @Autowired
    private CourseService service;
    private CoursesResource mockResource;

    private final String code = "fcb56955-5344-41e4-897b-d69387e5fa55";

    private Course course;

    @Before
    public void setUp() throws Exception {
        mockResource = mock(CoursesResourceImpl.class);
       // ((CourseServiceImpl)service).setResource(mockResource);
       // course = new Course("codeTest", "nameTest", CourseType.DEV, new Author("Vasya", "Pupkin", "vasia@gmail.com"),
         //       DateTime.now().toDate(), DateTime.now().toDate(), DateTime.now().toDate(), 10, "super description", CourseStatus.DRAFT);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(code);
        verify(mockResource).deleteByCode(code);
    }

    @Test(expected = ServiceProcessingException.class)
    public void testDeleteWithNullId() throws Exception {
        service.delete(null);
    }
}
