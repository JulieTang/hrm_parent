package com.maggie;

import com.maggie.hrm.Course9002Application;
import com.maggie.hrm.domain.CourseType;
import com.maggie.hrm.query.CourseTypeQuery;
import com.maggie.hrm.service.ICourseTypeService;
import com.maggie.hrm.util.PageList;
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
        PageList<CourseType> courseTypePageList = courseTypeService.selectListPage(new CourseTypeQuery());
        System.out.println(courseTypePageList.getTotal()); //
        System.out.println(courseTypePageList.getRows());
        System.out.println(courseTypePageList.getRows().size());
        for (CourseType courseType : courseTypePageList.getRows()) {
            System.out.println(courseType);
            System.out.println(courseType.getParent());
            System.out.println("============================");
        }
    }
}