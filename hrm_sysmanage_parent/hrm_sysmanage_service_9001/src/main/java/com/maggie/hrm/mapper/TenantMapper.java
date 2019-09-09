package com.maggie.hrm.mapper;

import com.maggie.hrm.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
public interface TenantMapper extends BaseMapper<Tenant> {

    /**
     * 保存机构所对应的套餐的中间表信息
     * @param mealMap
     */
    void saveTenantMeals(List<Map<String, Long>> mealMap);

    /**
     * 删除机构所对应的套餐的中间表信息
     * @param id
     */
    void removeTenantMeal(Serializable id);
}
