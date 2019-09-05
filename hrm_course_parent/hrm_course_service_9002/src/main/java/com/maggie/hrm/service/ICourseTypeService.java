package com.maggie.hrm.service;

import com.baomidou.mybatisplus.service.IService;
import com.maggie.hrm.domain.CourseType;
import com.maggie.hrm.query.CourseTypeQuery;
import com.maggie.hrm.util.PageList;

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
