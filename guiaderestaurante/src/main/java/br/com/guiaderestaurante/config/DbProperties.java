package br.com.guiaderestaurante.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.datasource")
public class DbProperties {
    private String url;
    private String password;
    private String username;
    private String driverClassName;
}
