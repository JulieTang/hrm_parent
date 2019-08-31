package com.maggie.service.impl;

import com.maggie.domain.CourseType;
import com.maggie.mapper.CourseTypeMapper;
import com.maggie.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-08-30
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

}
