package com.ms.codify.config.multitenant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Configuracion de Beans de intercepcion de request - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Slf4j
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
	
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
    	log.info("[preHandle]::inicio de metodo");
        String requestURI = request.getRequestURI();
        String tenantID = request.getHeader("X-TenantID");
        log.info("RequestURI::" + requestURI +" || Search for X-TenantID  :: " + tenantID);
        if (tenantID == null) {
            response.getWriter().write("X-TenantID not present in the Request Header");
            response.setStatus(400);
            return false;
        }
        TenantContext.setCurrentTenant(tenantID);
        log.info("[preHandle]::fin de metodo");
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    	log.info("[preHandle]::inicio-fin de metodo");
        TenantContext.clear();
    }

}
