package com.ms.codify.config.multitenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import com.ms.codify.config.TenantContext;

/**
 * Definiendo un tenant por defecto en este caso public - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver{

    private String defaultTenant ="public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String t =  TenantContext.getCurrentTenant();
        if(t!=null){
            return t;
        } else {
            return defaultTenant;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
