package com.maggie.hrm.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.maggie.hrm.domain.CourseType;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.maggie.hrm.query.CourseTypeQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程目录 Mapper 接口
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
public interface CourseTypeMapper extends BaseMapper<CourseType> {
    List<CourseType> loadListPage(Pagination page, @Param("query")CourseTypeQuery query);
}
