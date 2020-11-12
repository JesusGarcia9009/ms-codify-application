package com.ms.codify.config.multitenant;

import org.aspectj.lang.JoinPoint;
import org.hibernate.Session;

import com.ms.codify.config.TenantContext;
import com.ms.codify.service.CityService;

//@Aspect
//@Component
public class ServiceAspect {
    //@Before("execution(* com.example.service.discriminator.CityService.*(..))&& target(cityService) ")
    public void aroundExecution(JoinPoint pjp, CityService cityService) throws Throwable {
        org.hibernate.Filter filter = cityService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
        filter.validate();
    }
}
