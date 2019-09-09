package com.maggie.hrm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.maggie.hrm.domain.Employee;
import com.maggie.hrm.domain.Tenant;
import com.maggie.hrm.mapper.EmployeeMapper;
import com.maggie.hrm.mapper.MealMapper;
import com.maggie.hrm.mapper.TenantMapper;
import com.maggie.hrm.mapper.TenantTypeMapper;
import com.maggie.hrm.service.ITenantService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {
    @Autowired
    private TenantMapper tenantMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public boolean insert(Tenant tenant) {
        tenant.setRegisterTime(new Date());
        //添加机构类型
        tenant.setTenantType(tenant.getTenanttype().getId()); //添加机构类型
        System.out.println("=====================");
        System.out.println(tenant.getTenantType());
        //添加机构
        tenantMapper.insert(tenant);
        //添加管理员
        Employee adminUser = tenant.getAdminUser();
        adminUser.setInputTime(new Date()); //输入时间
        adminUser.setState(0); //正常
        adminUser.setType(true); //是否是机构管理员
        adminUser.setTenantId(tenant.getId()); //获取到机构id
        employeeMapper.insert(adminUser);
        //添加套餐中间表
        tenantMapper.saveTenantMeals(tenant.getMealMap()); //后台需要添加多对多的处理
        return true;
    }

    @Override
    public boolean deleteById(Serializable id) {
        //删除机构
        tenantMapper.deleteById(id);
        //删除管理员
        Wrapper<Employee> wapper = new EntityWrapper<>();
        wapper.eq("tenant_id",id);
        employeeMapper.delete(wapper);
        //删除中间表
        tenantMapper.removeTenantMeal(id);
        return true;
    }

    @Override
    public boolean updateById(Tenant tenant) {
        //修改机构
        tenantMapper.updateById(tenant);
        //修改管理员
        employeeMapper.updateById(tenant.getAdminUser());
        //修改中间表 --先删除后添加
        tenantMapper.removeTenantMeal(tenant.getId());
        tenantMapper.saveTenantMeals(tenant.getMealMap());
        return true;
    }
}
