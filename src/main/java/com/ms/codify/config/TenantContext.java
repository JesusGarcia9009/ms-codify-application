package com.ms.codify.config;


/**
 * Ejecuta hilo independiente para cada TenantID  - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class TenantContext {
    private static ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.set(null);
    }
}
