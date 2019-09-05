package com.maggie.hrm.client;

import com.maggie.hrm.domain.Course;
import com.maggie.hrm.query.CourseQuery;
import com.maggie.hrm.util.AjaxResult;
import com.maggie.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaggieTang
 * @since 2019-09-04
 */
@Component
public class CourseClientHystrixFallbackFactory implements FallbackFactory<CourseClient> {

    @Override
    public CourseClient create(Throwable throwable) {
        return new CourseClient() {
            @Override
            public AjaxResult save(Course course) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Course get(Long id) {
                return null;
            }

            @Override
            public List<Course> list() {
                return null;
            }

            @Override
            public PageList<Course> json(CourseQuery query) {
                return null;
            }
        };
    }
}
