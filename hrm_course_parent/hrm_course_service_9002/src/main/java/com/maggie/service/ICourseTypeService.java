package com.maggie.service;

import com.baomidou.mybatisplus.service.IService;
import com.maggie.domain.CourseType;
import com.maggie.query.CourseTypeQuery;
import com.maggie.util.PageList;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
public interface ICourseTypeService extends IService<CourseType> {

    /**
     * 高级查询+分页+关联查询
     * @param query
     * @return
     */
    PageList<CourseType> selectListPage(CourseTypeQuery query);
}
