package com.example.biometricvision;

import com.example.biometricvision.models.Asistencia;
import com.example.biometricvision.models.Carrera;
import com.example.biometricvision.models.Matriculacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BiometricvisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiometricvisionApplication.class, args);
                //new initbase().init();
	}

        
        @Bean
        public Matriculacion matriculacion()
        {
            return new Matriculacion();
        }
        
        
        @Bean
        public Asistencia asistencia()
        {
            return new Asistencia();
        }
        
        @Bean
        public Carrera carrera()
        {
            return new Carrera();
        }
        
        
        
        
        
        
}
