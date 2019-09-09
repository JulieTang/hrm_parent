package com.maggie.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FastJsonTest {
    @Test
    public void fastJsonTest() throws Exception{
        //1.对象转换为字符串
        Person person = new Person(1L,"maggie");
        Person person2 = new Person(2L,"tang");
        Person person3 = new Person(3L,"mara");
        //1.1.一个对象转换为字符串
        String jsonObjStr = JSONObject.toJSONString(person);
        System.out.println(jsonObjStr);
        //1.2.集合转换为字符串
        List<Person> personList = Arrays.asList(person,person2,person3,person);
        String jsonArrayString = JSONArray.toJSONString(personList);
        System.out.println(jsonArrayString);
        //2.字符串转换为对象
        //2.1.字符串转换为对象
        Person p = JSONObject.parseObject(jsonObjStr,Person.class);
        System.out.println(p);
        //字符串转换为集合
        List<Person> pers = JSONArray.parseArray(jsonArrayString,Person.class);
        System.out.println(pers);

        /**
         * 上面打印结果：
         * {"id":1,"name":"maggie"}
         * [{"id":1,"name":"maggie"},{"id":2,"name":"tang"},{"id":3,"name":"mara"},{"$ref":"$[0]"}]
         * Person{id=1, name='maggie'}
         * [Person{id=1, name='maggie'}, Person{id=2, name='tang'}, Person{id=3, name='mara'}, Person{id=1, name='maggie'}]
         */
    }
}
