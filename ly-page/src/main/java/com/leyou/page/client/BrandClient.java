package com.leyou.page.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: cuzz
 * @Date: 2018/11/9 16:21
 * @Description:
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi{
}
