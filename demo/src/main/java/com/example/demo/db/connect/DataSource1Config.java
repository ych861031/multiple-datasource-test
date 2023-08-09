package com.example.demo.db.connect;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo.repository.db1", // 第一個Repository的包路徑
        entityManagerFactoryRef = "entityManagerFactory1", // 指定dataSource1對應的entityManagerFactory
        transactionManagerRef = "transactionManager1" // 指定dataSource1對應的transactionManager
)
@EntityScan(basePackages = {
        "com.example.demo.model.db1" // Entity1的包路徑
})
public class DataSource1Config {

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource1() {
        return new HikariDataSource();
    }
    @Bean(name = "entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(
            @Qualifier("vendorAdapter1")JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource1());
        em.setPackagesToScan("com.example.demo.model.db1");
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setPersistenceUnitName("dataSource1PersistenceUnit");

        return em;
    }

    @Bean(name = "transactionManager1")
    public PlatformTransactionManager transactionManager1(@Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "vendorAdapter1")
    public JpaVendorAdapter jpaVendorAdapter1() {
        return new HibernateJpaVendorAdapter();
    }

}

