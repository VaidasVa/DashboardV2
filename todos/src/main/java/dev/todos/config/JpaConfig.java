//package dev.todos.config;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
////@ConfigurationProperties
//@Configuration
//@EnableJpaRepositories(basePackages = "dev.todos.repository")
//public class JpaConfig {
//
//    @Value("${db.url}")
//    private String dbUrl;
//
//    @Value("${db.username}")
//    private String dbUser;
//
//    @Value("${db.password}")
//    private String dbPassword;
//
//    @PostConstruct
//    public void init() {
//        System.out.println("Configured DB: " + dbUrl + " " + dbUser + " " + dbPassword);
//    }
////
////    @Bean
////    public DataSource dataSource() {
////        return DataSourceBuilder.create()
////                .url("jdbc:mysql://192.168.50.50:3306/dashboard2")
////
////                .username("root")
////                .password("root")
////                .driverClassName("com.mysql.cj.jdbc.Driver")
////                .build();
////    }
//
//}