package com.contador.msvc_asignaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;;

@SpringBootApplication
@EnableFeignClients
public class MsvcAsignacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcAsignacionesApplication.class, args);
	}

}
