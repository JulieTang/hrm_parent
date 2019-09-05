package com.maggie.hrm.service.impl;

import com.maggie.hrm.domain.Employee;
import com.maggie.hrm.mapper.EmployeeMapper;
import com.maggie.hrm.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
