package com.epxing.demo.api;

import com.epxing.demo.domain.TestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author chenling
 * @date 2020/1/6 0:47
 * @since V1.0.0
 */
@FeignClient("epxing-demo")
@RequestMapping("epxing/demo")
public interface TestApi {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    TestResult   getEntity( @RequestParam String name);

}
