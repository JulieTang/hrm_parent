package com.maggie.hrm.web.controller;

import com.maggie.hrm.service.IPageConfigService;
import com.maggie.hrm.domain.PageConfig;
import com.maggie.hrm.query.PageConfigQuery;
import com.maggie.hrm.util.AjaxResult;
import com.maggie.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MaggieTang
 * @since 2019-09-08
 */

@RestController
@RequestMapping("/pageConfig")
public class PageConfigController {
    @Autowired
    public IPageConfigService pageConfigService;

    /**
    * 保存和修改公用的
    * @param pageConfig  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody PageConfig pageConfig){
        try {
            if(pageConfig.getId()!=null){
                pageConfigService.updateById(pageConfig);
            }else{
                pageConfigService.insert(pageConfig);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            pageConfigService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public PageConfig get(@PathVariable("id")Long id)
    {
        return pageConfigService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<PageConfig> list(){

        return pageConfigService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<PageConfig> json(@RequestBody PageConfigQuery query)
    {
        Page<PageConfig> page = new Page<PageConfig>(query.getPage(),query.getRows());
            page = pageConfigService.selectPage(page);
            return new PageList<PageConfig>(page.getTotal(),page.getRecords());
    }
}
