package com.maggie.hrm.client;

import com.maggie.hrm.domain.Permission;
import com.maggie.hrm.query.PermissionQuery;
import com.maggie.hrm.util.AjaxResult;
import com.maggie.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MaggieTang
 * @since 2019-09-04
 */

@FeignClient(value = "ZUUL-GATEWAY",configuration = FeignClientsConfiguration.class,
        fallbackFactory = PermissionClientHystrixFallbackFactory.class)
@RequestMapping("/permission")
public interface PermissionClient {
    /**
     * 保存和修改公用的
     * @param permission  传递的实体
     * @return Ajaxresult转换结果
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    AjaxResult save(Permission permission);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @RequestMapping("/{id}")
    Permission get(@RequestParam(value = "id", required = true) Long id);


    /**
     * 查看所有的员工信息
     * @return
     */
    @RequestMapping("/list")
    public List<Permission> list();

    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    PageList<Permission> json(@RequestBody PermissionQuery query);
}
