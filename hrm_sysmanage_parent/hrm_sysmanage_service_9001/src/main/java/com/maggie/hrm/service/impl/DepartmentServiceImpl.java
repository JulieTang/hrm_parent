package com.maggie.hrm.service.impl;

import com.maggie.hrm.domain.Department;
import com.maggie.hrm.mapper.DepartmentMapper;
import com.maggie.hrm.service.IDepartmentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
