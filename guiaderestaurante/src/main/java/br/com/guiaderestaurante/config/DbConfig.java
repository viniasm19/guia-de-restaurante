package br.com.guiaderestaurante.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DbProperties.class)
public class DbConfig {
    private final DbProperties props;

    public DbConfig(DbProperties props){
        this.props = props;
    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create().
                driverClassName(props.getDriverClassName()).
                username(props.getUsername()).
                password(props.getPassword()).
                url(props.getUrl()).build();
    }
}
