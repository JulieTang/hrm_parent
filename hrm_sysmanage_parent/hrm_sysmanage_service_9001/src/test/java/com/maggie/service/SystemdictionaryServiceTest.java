package com.maggie.service;

import com.maggie.SysManage9001Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysManage9001Application.class)
public class SystemdictionaryServiceTest {
    @Autowired
    private ISystemdictionaryService systemdictionaryService;
    @Test
    public void testSystemDictonary() throws Exception{
        systemdictionaryService.selectList(null).forEach(e-> System.out.println(e));
    }
}
