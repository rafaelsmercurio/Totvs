package br.com.totvs.clienttotvs.config;

import com.google.common.collect.Lists;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${project.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.totvs")).paths(PathSelectors.any()).build()
                .tags(new Tag("Totvs", "Consultas"))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Lists.newArrayList(securityContext())).apiInfo(apiInfo());

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Api de Consulta de clientes totvs")
                .description("Canal de Consulta de dados de clientes totvs")
                .termsOfServiceUrl("https://www.totvs,com.br/politicaprivacidade").version(this.version)
                .contact(new Contact(null, null, "atendimento@totvs.com.br")).license("Apache 2.0")
                .licenseUrl("").build();
    }

    @Bean
    SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }

    List<SecurityReference> defaultAuth() {
        var authorizationScope = new AuthorizationScope("Global", "acessEverything");
        var authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));

    }

    ApiKey apiKey() {
        return new ApiKey("JWT", HttpHeaders.AUTHORIZATION, ApiKeyVehicle.HEADER.getValue());
    }
}
