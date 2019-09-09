package com.maggie.hrm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.maggie.hrm.domain.Pager;
import com.maggie.hrm.mapper.PagerMapper;
import com.maggie.hrm.query.PagerQuery;
import com.maggie.hrm.service.IPagerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maggie.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-08
 */
@Service
public class PagerServiceImpl extends ServiceImpl<PagerMapper, Pager> implements IPagerService {

    @Autowired
    private PagerMapper pagerMapper;

    /**
     * 高级查询+分页+关联查询
     *
     * @param query
     * @return
     */
    @Override
    public PageList<Pager> selectListPage(PagerQuery query) {
        Pagination page = new Pagination(query.getPage(),query.getRows());
        List<Pager> pagers = pagerMapper.loadListPage(page,query);
        System.out.println(pagers);
        return new PageList<>(page.getTotal(),pagers);
    }

    /**
     * 插入页面详情的同时, 插入站点数据
     * @param pager
     * @return
     */
    @Override
    public boolean insert(Pager pager) {
        //插入站点类型
        pager.setSiteId(pager.getSite().getId());
        //插入页面
        return super.insert(pager);
    }


    @Override
    public boolean updateById(Pager pager) {
//        pagerMapper.updateById(pager);
        pager.setSiteId(pager.getSite().getId());
        return super.updateById(pager);
    }
}
