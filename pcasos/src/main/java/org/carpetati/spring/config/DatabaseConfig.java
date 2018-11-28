package org.carpetati.spring.config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = { "org.carpetati.spring.service" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= {"org.carpetati.spring.dao"})
public class DatabaseConfig {

	private ComboPooledDataSource ds;

	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		// ComboPooledDataSource ds = new ComboPooledDataSource();
		ds = new ComboPooledDataSource();
		ds.setDriverClass("org.mariadb.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mariadb://localhost:3306/carpetatidev");
		ds.setUser("Developer");
		ds.setPassword("Desarrollo123");
		ds.setMaxPoolSize(10);
		ds.setMinPoolSize(5);
		ds.setMaxStatements(50);
		return ds;
	}

	@Bean
	public Connection connection() throws SQLException {
		return ds.getConnection();
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransaction = new JpaTransactionManager();
		jpaTransaction.setEntityManagerFactory(entityManagerFactory);
		return jpaTransaction;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		// emf.setPersistenceUnitName("spring-jpa-unit");
		entityManagerFactory.setPackagesToScan("org.carpetati.spring.model");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties jpaproperties = new Properties();
		jpaproperties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
		jpaproperties.put("hibernate.hbm2ddl.auto", "validate");
		jpaproperties.put("hibernate.show_sql", "true");
		jpaproperties.put("hibernate.connection.SetBigStringTryClob", "true");
		jpaproperties.put("hibernate.jdbc.batch_size", 0);

		entityManagerFactory.setJpaProperties(jpaproperties);
		return entityManagerFactory;
	}

}
