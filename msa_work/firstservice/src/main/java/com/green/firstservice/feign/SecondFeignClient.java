package com.green.firstservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="second-service", url = "${second-service-url}")
public interface SecondFeignClient {

    @GetMapping("/second-service/test")
    String getTest();
}
