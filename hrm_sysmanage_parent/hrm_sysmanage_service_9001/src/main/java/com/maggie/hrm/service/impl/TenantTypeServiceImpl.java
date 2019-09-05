package com.maggie.hrm.service.impl;

import com.maggie.hrm.domain.TenantType;
import com.maggie.hrm.mapper.TenantTypeMapper;
import com.maggie.hrm.service.ITenantTypeService;
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
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType> implements ITenantTypeService {

}
