package com.maggie.client;

import com.maggie.domain.Systemdictionary;
import com.maggie.query.SystemdictionaryQuery;
import com.maggie.util.AjaxResult;
import com.maggie.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaggieTang
 * @since 2019-08-30
 */
@Component
public class SystemdictionaryClientHystrixFallbackFactory implements FallbackFactory<SystemdictionaryClient> {

    @Override
    public SystemdictionaryClient create(Throwable throwable) {
        return new SystemdictionaryClient() {
            @Override
            public AjaxResult save(Systemdictionary systemdictionary) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Systemdictionary get(Long id) {
                return null;
            }

            @Override
            public List<Systemdictionary> list() {
                return null;
            }

            @Override
            public PageList<Systemdictionary> json(SystemdictionaryQuery query) {
                return null;
            }
        };
    }
}
