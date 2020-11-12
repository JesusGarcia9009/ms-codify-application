package com.ms.codify.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by suman.das on 7/22/19.
 */
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    public RestTemplateHeaderModifierInterceptor() {

    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        
        String projectId = TenantContext.getCurrentTenant();
        request.getHeaders().add("X-TenantID", projectId);
        ClientHttpResponse response = clientHttpRequestExecution.execute(request, body);
        response.getHeaders().add("X-TenantID", projectId);
        return response;


    }
}
