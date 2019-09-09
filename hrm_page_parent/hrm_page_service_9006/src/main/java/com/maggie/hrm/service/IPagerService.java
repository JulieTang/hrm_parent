package com.maggie.hrm.service;

import com.maggie.hrm.domain.Pager;
import com.baomidou.mybatisplus.service.IService;
import com.maggie.hrm.query.PagerQuery;
import com.maggie.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-08
 */
public interface IPagerService extends IService<Pager> {

    /**
     * 高级查询+分页+关联查询
     * @param query
     * @return
     */
    PageList<Pager> selectListPage(PagerQuery query);
}
