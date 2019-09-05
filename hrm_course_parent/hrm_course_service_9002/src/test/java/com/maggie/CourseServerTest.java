package com.maggie;

import com.maggie.hrm.Course9002Application;
import com.maggie.hrm.service.ICourseTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Course9002Application.class)
public class CourseServerTest {
    @Autowired
    private ICourseTypeService courseTypeService;
    @Test
    public void testSystemDictonary() throws Exception{
        courseTypeService.selectList(null).forEach(e-> System.out.println(e));
    }
}