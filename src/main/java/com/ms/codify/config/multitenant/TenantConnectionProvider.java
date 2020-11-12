package com.ms.codify.config.multitenant;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Coneccion a la bse de datos - Provider de base de datos por tenant - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Slf4j
@Component
public class TenantConnectionProvider implements MultiTenantConnectionProvider {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String DEFAULT_TENANT = "public";
	
    private DataSource datasource;
    

    public TenantConnectionProvider(DataSource dataSource) {
        this.datasource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return datasource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
    	log.info("[getConnection] :: inicio Metodo :: tenant {}", tenantIdentifier);
        final Connection connection = getAnyConnection();
        connection.setSchema(tenantIdentifier);
        
        log.info("[getConnection] :: fin del Metodo ");
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
    	log.info("[releaseConnection] :: inicio Metodo :: tenant {}", tenantIdentifier);
        connection.setSchema(DEFAULT_TENANT);
        releaseAnyConnection(connection);
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean isUnwrappableAs(Class aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }
}
