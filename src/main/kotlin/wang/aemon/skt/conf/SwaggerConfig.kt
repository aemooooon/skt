package wang.aemon.skt.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2 // 启用Swagger
open class SwaggerConfig {

    companion object {
        const val SWAGGER_SCAN_BASE_PACKAGE = "wang.aemon.skt";
        const val VERSION = "1.0.0";
    }

    @Bean
    open fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
            //  api接口包扫描路径
            // 只对restApi路径下面的所有连接请求
            //.paths(regex("/restApi.*"))
            // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
            .paths(PathSelectors.any()) .build();

    }

    fun apiInfo(): ApiInfo {
        // 设置文档的标题
        return ApiInfoBuilder().title("Swagger2 接口文档示例")
            // 设置文档的描述->1.Overview
            .description("SKT")
            // 设置文档的版本信息-> 1.1 Version information
            .version(VERSION)
            .termsOfServiceUrl("www.apache.org")
            .build();
    }
}