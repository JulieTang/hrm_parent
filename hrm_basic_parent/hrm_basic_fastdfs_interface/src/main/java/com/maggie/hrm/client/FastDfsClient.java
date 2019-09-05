package com.maggie.hrm.client;

import com.maggie.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MaggieTang
 * @since 2019-08-30
 */

@FeignClient(value = "ZUUL-GATEWAY",configuration = FeignClientsConfiguration.class)
       // fallbackFactory = SystemdictionaryClientHystrixFallbackFactory.class)
@RequestMapping("/product/systemdictionary")
public interface FastDfsClient {
    /**
     * 上传图片
     * @param multipartFile
     * @return
     */
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    String upload(MultipartFile multipartFile);

    /**
     * 删除图片
     * @param path
     * @return
     */
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    AjaxResult delete(String path);

    /**
     * 下载图片
     * @param path
     * @return
     */
    @RequestMapping("/download")
    byte[] download(String path);


}
