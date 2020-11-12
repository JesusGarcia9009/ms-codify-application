package com.ms.codify.config.multitenant;

/**
 * Se setea el tenant al contexto de hibernate - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface TenantSupport {
   void setTenantId(String tenantId);
}
