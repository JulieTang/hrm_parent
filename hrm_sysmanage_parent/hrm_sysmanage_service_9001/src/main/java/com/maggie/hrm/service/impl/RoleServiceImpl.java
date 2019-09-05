package com.maggie.hrm.service.impl;

import com.maggie.hrm.domain.Role;
import com.maggie.hrm.mapper.RoleMapper;
import com.maggie.hrm.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
