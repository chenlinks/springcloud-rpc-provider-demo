package com.epxing.demo.service.impl;

import com.epxing.demo.api.TestApi;
import com.epxing.demo.domain.TestResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenling
 * @date 2020/1/6 0:52
 * @since V1.0.0
 */
@RestController
public class TestApiImpl  implements TestApi {

    @Override
    public TestResult getEntity(String name) {
        TestResult result = new  TestResult();
        result.setCode(true);
        result.setMsg("测试成功。。。。。");
        return result;
    }
}
