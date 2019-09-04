package com.maggie.client;

import com.maggie.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MaggieTang
 * @since 2019-08-30
 */
@Component
public class FastDfsClientHystrixFallbackFactory implements FallbackFactory<FastDfsClient> {

    @Override
    public FastDfsClient create(Throwable throwable) {
        return new FastDfsClient() {
            @Override
            public String upload(MultipartFile multipartFile) {
                return null;
            }

            @Override
            public AjaxResult delete(String path) {
                return null;
            }

            @Override
            public byte[] download(String path) {
                return new byte[0];
            }
        };
    }
}
