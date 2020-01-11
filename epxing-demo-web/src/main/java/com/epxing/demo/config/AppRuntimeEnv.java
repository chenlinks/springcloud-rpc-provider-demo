package com.epxing.demo.config;

import cn.hutool.core.util.IdUtil;
import com.epxing.demo.enums.ResultEnum;
import com.epxing.demo.exception.ApplicationException;
import org.springframework.stereotype.Component;

/**
 * @author chenling
 */
@Component
public class AppRuntimeEnv {

    // 租户编码
    private ThreadLocal<String> tenantId = ThreadLocal.withInitial(() -> null);

    // token信息
    private ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);

    // requestId
    private ThreadLocal<String> requestId = ThreadLocal.withInitial(IdUtil::simpleUUID);


    public AppRuntimeEnv ensureToken(String token) throws Exception {
        if (null == token) {
            throw new ApplicationException(ResultEnum.TOKEN_NOT_FOUND);
        }
        this.token.set(token);
        return this;
    }

    public AppRuntimeEnv ensureTenantId(String tenantId) throws Exception {
        if (null == tenantId) {
            throw new ApplicationException(ResultEnum.TENANT_NOT_FOUND);
        }
        this.tenantId.set(tenantId);
        return this;
    }

    public void setTenantId(String tenantId) {
        this.tenantId.set(tenantId);
    }

    public void setToken(String token) {
        this.token.set(token);
    }

    public String getTenantId() {
        return tenantId.get();
    }

    public String getToken() {
        return token.get();
    }



    public String getRequestId() {
        return requestId.get();
    }

}
