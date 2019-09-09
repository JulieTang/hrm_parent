package com.maggie.hrm.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.maggie.hrm.service.IPagerService;
import com.maggie.hrm.domain.Pager;
import com.maggie.hrm.query.PagerQuery;
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
@RequestMapping("/pager")
public class PagerController {
    @Autowired
    public IPagerService pagerService;

    /**
    * 保存和修改公用的
    * @param pager  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Pager pager){
        try {
            if(pager.getId()!=null){
                pagerService.updateById(pager);
            }else{
                pagerService.insert(pager);
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
            pagerService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Pager get(@PathVariable("id")Long id)
    {
        return pagerService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Pager> list(){

        return pagerService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Pager> json(@RequestBody PagerQuery query)
    {
        /*Page<Pager> page = new Page<Pager>(query.getPage(),query.getRows());
            page = pagerService.selectPage(page);
            return new PageList<Pager>(page.getTotal(),page.getRecords());*/
        return pagerService.selectListPage(query);
    }
}
