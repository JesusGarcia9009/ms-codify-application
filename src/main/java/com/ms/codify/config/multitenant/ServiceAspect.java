package com.ms.codify.config.multitenant;

import org.aspectj.lang.JoinPoint;
import org.hibernate.Session;

import com.ms.codify.service.CityServiceImpl;

/**
 * Aspecto que redefine el comportamiento de los servicios para que tome los repositorios asociados al tenant - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class ServiceAspect {

	public void aroundExecution(JoinPoint pjp, CityServiceImpl cityService) throws Throwable {
        org.hibernate.Filter filter = cityService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
        filter.validate();
    }
	
}
