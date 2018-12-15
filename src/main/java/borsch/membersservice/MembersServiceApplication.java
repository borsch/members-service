package borsch.membersservice;

import borsch.membersservice.security.JwtTokenFilter;
import borsch.membersservice.services.members.MemberMapperConfiguration;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
@EnableMongoRepositories(basePackages = "borsch.membersservice.persistence.dao")
public class MembersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersServiceApplication.class, args);
	}

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(path -> path.startsWith("/api/"))
                .build()
                .globalOperationParameters(Collections.singletonList(new ParameterBuilder()
                        .name(JwtTokenFilter.AUTH_HEADER)
                        .description("token for authorization")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .build()));
    }

    @Bean
    public MapperFacade mapperFactory() {
	    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        MemberMapperConfiguration.configureMapperFactory(mapperFactory);

	    return mapperFactory.getMapperFacade();
    }

}