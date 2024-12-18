package org.sergey_white.statement.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public OpenAPI calculatorOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Statement API")
                        .version("1.0")
                        .description("API для получения предварительного расчета предложений по кредиту и " +
                                "выбора одного из предложения"));
    }
}
