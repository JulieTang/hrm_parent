package com.maggie.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.maggie.hrm.domain.CourseType;
import com.maggie.hrm.mapper.CourseTypeMapper;
import com.maggie.hrm.query.CourseTypeQuery;
import com.maggie.hrm.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maggie.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;
    /**
     * 高级查询+分页+关联查询
     *
     * @param query
     * @return
     */
    @Override
    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        Pagination page = new Pagination(query.getPage(),query.getRows());
        List<CourseType> courseTypes = courseTypeMapper.loadListPage(page, query);
        return new PageList<CourseType>(page.getTotal(),courseTypes);
    }
}
