package com.maggie.hrm.web.controller;

import com.maggie.hrm.service.ISiteService;
import com.maggie.hrm.domain.Site;
import com.maggie.hrm.query.SiteQuery;
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
@RequestMapping("/site")
public class SiteController {
    @Autowired
    public ISiteService siteService;

    /**
    * 保存和修改公用的
    * @param site  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Site site){
        try {
            if(site.getId()!=null){
                System.out.println("*****************************");
                siteService.updateById(site);
            }else{
                System.out.println("=================================");
                siteService.insert(site);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存对象失败！"+e.getMessage());
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
            siteService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Site get(@PathVariable("id")Long id)
    {
        return siteService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Site> list(){

        return siteService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象*/
    /*@RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Site> json(@RequestBody SiteQuery query)
    {
        Page<Site> page = new Page<Site>(query.getPage(),query.getRows());
            page = siteService.selectPage(page);
            return new PageList<Site>(page.getTotal(),page.getRecords());
    }*/

    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Site> json(@RequestBody SiteQuery query)
    {
        return siteService.selectListPage(query);
    }
}
