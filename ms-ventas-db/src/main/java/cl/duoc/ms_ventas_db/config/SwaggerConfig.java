package cl.duoc.ms_ventas_db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                   .info(new Info().title("API de Ventas (ms-ventas-db) - Perfulandia")
                    .description("Microservicio encargado de gestionar la persistencia de pedidos y sus detalles en el sistema de ventas. "
                        + "Expone endpoints para obtener pedidos con sus respectivos detalles, así como registrar nuevos pedidos a través de DTOs.")
                                    .version("1.0.0"));
    }

}
