package com.maggie.hrm.service.impl;

import com.maggie.hrm.Course9002Application;
import com.maggie.hrm.domain.CourseType;
import com.maggie.hrm.service.ICourseTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Course9002Application.class)
public class CourseTypeServiceImplTest {
    @Autowired
    private ICourseTypeService courseTypeService;
    @Test
    public void selectListPage() {
    }

    @Test
    public void queryTypeTree() {
//        List<CourseType> courseTypes = courseTypeService.queryTypeTree(1L);
        List<CourseType> courseTypes = courseTypeService.queryTypeTree(1L);
        courseTypes.forEach(e-> System.out.println(e));
    }
}