package com.ms.codify.config.multitenant;

/**
 * Constantes de inicio de proyecto  - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface MultiTenantConstants {
    String DEFAULT_TENANT_ID = "public";
    String CURRENT_TENANT_IDENTIFIER = "CURRENT_TENANT_IDENTIFIER";
    String TENANT_KEY = "tenant";
}
