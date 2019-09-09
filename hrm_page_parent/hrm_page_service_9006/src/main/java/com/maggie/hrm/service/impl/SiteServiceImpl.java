package com.maggie.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.maggie.hrm.domain.Pager;
import com.maggie.hrm.domain.Site;
import com.maggie.hrm.mapper.PagerMapper;
import com.maggie.hrm.mapper.SiteMapper;
import com.maggie.hrm.query.PagerQuery;
import com.maggie.hrm.query.SiteQuery;
import com.maggie.hrm.service.ISiteService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maggie.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements ISiteService {

    @Autowired
    private SiteMapper siteMapper;
    /**
     * 高级查询+分页+关联查询
     *
     * @param query
     * @return
     */
    @Override
    public PageList<Site> selectListPage(SiteQuery query) {
        Pagination page = new Pagination(query.getPage(),query.getRows());
        List<Site> sites = siteMapper.loadListPage(page,query);

        return new PageList<>(page.getTotal(),sites);
    }

}
