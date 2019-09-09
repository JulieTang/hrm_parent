package com.maggie.hrm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.maggie.hrm.domain.CourseType;
import com.maggie.hrm.mapper.CourseTypeMapper;
import com.maggie.hrm.query.CourseTypeQuery;
import com.maggie.hrm.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maggie.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;

    /**
     * 高级查询+分页+关联查询
     *
     * @param query
     * @return
     */
    @Override
    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        /**
         * query.getPage(),query.getRows() 要是不传参数进来，就没法分页翻页
         */
        Pagination page = new Pagination(query.getPage(), query.getRows());
        List<CourseType> courseTypes = courseTypeMapper.loadListPage(page, query);
        return new PageList<>(page.getTotal(), courseTypes);
    }



    @Override
    public List<CourseType> queryTypeTree(Long pid) {
        //return getCourseTypesRecursion(pid);
        return queryTypeTreeLoop(pid);
    }

    /**
     * 方案一：递归（根据传入的id作为父类id,查询所有的子课程类型）
     * 【每次都要发送sql效率低下】
     * @param pid
     * @return
     */
    public List<CourseType> getCourseTypesRecursion(Long pid) {
        List<CourseType> children = courseTypeMapper.selectList(new EntityWrapper<CourseType>().eq("pid", pid));
        if (children == null || children.size() < 1) {
            return null;
        }
        for (CourseType child : children) {
            //自己调用自己
            List<CourseType> courseTypes = queryTypeTree(child.getId());
            child.setChildren(courseTypes);
        }
        return children;
    }

    /**
     * 方案二：循环（一次sql，获取所有的类型）
     *
     * @param pid
     * @return
     */
    public List<CourseType> queryTypeTreeLoop(Long pid) {

        List<CourseType> result = new ArrayList<>();
        //1 查询所有类型
        List<CourseType> allTypes = courseTypeMapper.selectList(null);
        //建立id和CourseType的关联关系
        Map<Long,CourseType> allTypesDto = new HashMap<>();
        for (CourseType allType : allTypes) {
            allTypesDto.put(allType.getId(),allType);
        }
        //2 遍历判断是否是第一级  pid为传入id,
        for (CourseType type : allTypes) {
            Long pidTmp = type.getPid();
            //2.1是直接加入返回列表
            if (pidTmp.longValue()== pid.longValue()){
                result.add(type);
            }else{
                //2.2不是要把自己作为父亲儿子
                //通过pid获取父亲
                //方案1:遍历所有,通过父亲id来获取父亲
                /*
                for (CourseType courseType : allTypes) {
                    if(courseType.getId().longValue() == pidTmp.longValue()){
                        courseType.getChildren().add(type);
                    }
                }*/
                //方案2:通过map获取
                CourseType parent = allTypesDto.get(pidTmp);
                //获取父亲儿子集合,把自己加进去
                parent.getChildren().add(type);
            }
        }
        return result;
    }
}
