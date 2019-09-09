package com.maggie.hrm.service.impl;

import com.maggie.hrm.SitPageConfig9006Application;
import com.maggie.hrm.domain.Pager;
import com.maggie.hrm.query.PagerQuery;
import com.maggie.hrm.service.IPagerService;
import com.maggie.hrm.util.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SitPageConfig9006Application.class)
public class PagerServiceImplTest {
    @Autowired
    private IPagerService pagerService;
    @Test
    public void testQuery() throws Exception{
        PageList<Pager> pagerPageList = pagerService.selectListPage(new PagerQuery());
        System.out.println(pagerPageList.getTotal());
        System.out.println(pagerPageList.getRows());
        System.out.println(pagerPageList.getRows().size());

        for (Pager pager : pagerPageList.getRows()) {
            System.out.println(pager);
            System.out.println("******************************************");;
            System.out.println(pager.getSite());
            System.out.println("==============================");;
        }

    }

}