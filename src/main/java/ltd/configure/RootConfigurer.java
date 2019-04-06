package ltd.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan("ltd")
@EnableJpaRepositories(value = "ltd")
@EnableTransactionManagement
public class RootConfigurer implements TransactionManagementConfigurer {

    @Autowired
    private Environment environment;

    @Bean("dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }


    @Bean("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(false);

        jpaVendorAdapter.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaVendorAdapter.getJpaPropertyMap().put("hibernate.max_fetch_depth", 3);
        jpaVendorAdapter.getJpaPropertyMap().put("hibernate.jdbc.fetch_size", 50);
        jpaVendorAdapter.getJpaPropertyMap().put("hibernate.jdbc.batch_size", 10);

        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setPackagesToScan("ltd");
        managerFactoryBean.setDataSource(dataSource());
        managerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        managerFactoryBean.afterPropertiesSet();
        return managerFactoryBean.getObject();
    }

    @Bean("entityManager")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
}
