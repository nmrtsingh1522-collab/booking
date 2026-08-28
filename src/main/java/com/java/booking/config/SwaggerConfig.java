package com.java.booking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI touristBookingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tourist Booking API")
                        .description("REST API for managing tourists and bookings")
                        .version("1.0"));
    }
}
