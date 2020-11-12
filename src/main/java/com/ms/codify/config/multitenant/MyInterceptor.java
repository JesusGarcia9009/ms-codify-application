package com.ms.codify.config.multitenant;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Interceptor de hibernate - distincion de esquema en dependecia de tenant  - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class MyInterceptor {

    private JpaProperties jpaProperties;

    public EmptyInterceptor hibernateInterceptor() {
        return new EmptyInterceptor() {

            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
                if (entity instanceof TenantSupport) {
                    ((TenantSupport) entity).setTenantId(TenantContext.getCurrentTenant());
                }
            }


            @Override
            public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
                if (entity instanceof TenantSupport) {
                    ((TenantSupport) entity).setTenantId(TenantContext.getCurrentTenant());
                }
                return false;
            }

            @Override
            public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
                if (entity instanceof TenantSupport) {
                    ((TenantSupport) entity).setTenantId(TenantContext.getCurrentTenant());
                }
                return false;
            }
        };
    }

    //@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factory, DataSource dataSource, JpaProperties properties) {
        Map<String, Object> jpaPropertiesMap = new HashMap<>(jpaProperties.getProperties());
        jpaPropertiesMap.put("hibernate.ejb.interceptor", hibernateInterceptor());
        return factory.dataSource(dataSource).packages("com.ms.codify").properties(jpaPropertiesMap).build();
    }
}
