package com.maggie.hrm.service.impl;

import com.maggie.hrm.ES9004Application;
import com.maggie.hrm.doc.EsCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ES9004Application.class)
public class EsCourseServiceImplTest {
    @Autowired
    private ElasticsearchTemplate template;
    @Test
    public void updateById() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void selectById() {
    }
    @Test
    public void testInit() throws Exception {
        template.createIndex(EsCourse.class);
        template.putMapping(EsCourse.class);
    }
    @Test
    public void selectList() {

    }

    @Test
    public void selectListPage() {
    }

    @Test
    public void batchSave() {
    }

    @Test
    public void batchDel() {
    }
}