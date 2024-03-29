package com.maggie.hrm.service.impl;

import com.maggie.hrm.doc.EsCourse;
import com.maggie.hrm.query.EsCourseQuery;
import com.maggie.hrm.repostory.EsCourseRepostory;
import com.maggie.hrm.service.IEsCourseService;
import com.maggie.hrm.util.PageList;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EsCourseServiceImpl  implements IEsCourseService {
    @Autowired
    private EsCourseRepostory esCourseRepostory;
    @Override
    public void updateById(EsCourse esCourse) {
        esCourseRepostory.save(esCourse);
    }

    @Override
    public void insert(EsCourse esCourse) {
        esCourseRepostory.save(esCourse);
    }

    @Override
    public void deleteById(Long id) {
        esCourseRepostory.deleteById(id);
    }

    @Override
    public EsCourse selectById(Long id) {
        return esCourseRepostory.findById(id).get();
    }

    @Override
    public List<EsCourse> selectList(Object o) {
        System.out.println(esCourseRepostory.findAll().getClass());
        Page page = (Page) esCourseRepostory.findAll();
        return page.getContent();
    }

    /**
     * 分页查询
     * @param query
     * @return
     */
    @Override
    public PageList<EsCourse> selectListPage(EsCourseQuery query) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        BoolQueryBuilder bool = QueryBuilders.boolQuery();
        //模糊查询 @TODO
        bool.must(QueryBuilders.matchQuery("intro", "zhang"));
        //精确过滤 @TODO
        List<QueryBuilder> filters = bool.filter();
        filters.add(QueryBuilders.rangeQuery("age").gte(0).lte(200));

        builder.withQuery(bool); //query bool must(filter)
        //排序 @TODO
        builder.withSort(SortBuilders.fieldSort("age").order(SortOrder.ASC));

        //分页 当前页从0开始
        builder.withPageable(PageRequest.of(query.getPage()-1, query.getRows()));

        //构造查询条件
        NativeSearchQuery esQuery = builder.build();
        //查询
        Page<EsCourse> page = esCourseRepostory.search(esQuery);
        return new PageList<>(page.getTotalElements(),page.getContent());
    }

    /**
     * 批量添加索引库
     *
     * @param esCourseList
     */
    @Override
    public void batchSave(List<EsCourse> esCourseList) {
        esCourseRepostory.saveAll(esCourseList);
    }

    /**
     * 批量删除索引库
     *
     * @param esCourseList
     */
    @Override
    public void batchDel(List<EsCourse> esCourseList) {
        esCourseRepostory.deleteAll(esCourseList);
    }
}
