package com.maggie.hrm.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.maggie.hrm.domain.Pager;
import com.maggie.hrm.domain.Site;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.maggie.hrm.query.PagerQuery;
import com.maggie.hrm.query.SiteQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-08
 */
public interface SiteMapper extends BaseMapper<Site> {

    List<Site> loadListPage(Pagination page, @Param("query")SiteQuery query);
}
