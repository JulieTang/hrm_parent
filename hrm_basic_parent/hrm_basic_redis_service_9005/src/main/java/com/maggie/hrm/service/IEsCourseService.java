package com.maggie.hrm.service;

import com.maggie.hrm.doc.EsCourse;
import com.maggie.hrm.query.EsCourseQuery;
import com.maggie.hrm.util.PageList;

import java.util.List;

public interface IEsCourseService {

    void updateById(EsCourse esCourse);

    void insert(EsCourse esCourse);

    void deleteById(Long id);

    EsCourse selectById(Long id);

    List<EsCourse> selectList(Object o);

    PageList<EsCourse> selectListPage(EsCourseQuery query);

    /**
     * 批量添加索引库
     * @param ids
     */
    void batchSave(List<EsCourse> ids);

    /**
     * 批量删除索引库
     * @param esCourseList
     */
    void batchDel(List<EsCourse> esCourseList);
}
