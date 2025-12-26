// //package com.example.demo.config;

// //import io.swagger.v3.oas.models.OpenAPI;
// //import io.swagger.v3.oas.models.servers.Server;
// //import org.springframework.context.annotation.Bean;
// //import org.springframework.context.annotation.Configuration;
// //import java.util.List;

// //@Configuration
// //public class OpenApiConfig {

//   //  @Bean
//     //public OpenAPI customOpenAPI() {
//       //  return new OpenAPI()
//                 // You need to change the port as per your server
//         //        .servers(List.of(
//           //              new Server().url("https://9296.408procr.amypo.ai/")
//             //    ));
//         //}
// //}



package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 1. API Info
                .info(new Info()
                        .title("Transport Optimization API")
                        .version("1.0")
                        .description("API Documentation with JWT Authentication"))
                
                // 2. Server Configuration (Your custom URL)
                .servers(List.of(
                        new Server().url("https://9296.408procr.amypo.ai/")
                ))

                // 3. Activate Security Globally (This puts the padlock on every endpoint)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))

                // 4. Define the Security Scheme (This creates the 'Authorize' button logic)
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}