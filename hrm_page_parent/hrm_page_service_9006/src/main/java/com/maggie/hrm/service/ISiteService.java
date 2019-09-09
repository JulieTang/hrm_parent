package com.maggie.hrm.service;

import com.maggie.hrm.domain.Site;
import com.baomidou.mybatisplus.service.IService;
import com.maggie.hrm.query.SiteQuery;
import com.maggie.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-08
 */
public interface ISiteService extends IService<Site> {

    PageList<Site> selectListPage(SiteQuery query);
}
