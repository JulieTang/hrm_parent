package com.maggie.hrm.client;

import com.maggie.hrm.domain.Pager;
import com.maggie.hrm.query.PagerQuery;
import com.maggie.hrm.util.AjaxResult;
import com.maggie.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaggieTang
 * @since 2019-09-08
 */
@Component
public class PagerClientHystrixFallbackFactory implements FallbackFactory<PagerClient> {

    @Override
    public PagerClient create(Throwable throwable) {
        return new PagerClient() {
            @Override
            public AjaxResult save(Pager pager) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Pager get(Long id) {
                return null;
            }

            @Override
            public List<Pager> list() {
                return null;
            }

            @Override
            public PageList<Pager> json(PagerQuery query) {
                return null;
            }
        };
    }
}
