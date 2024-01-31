/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision;

import com.example.biometricvision.models.Carrera;
import com.example.biometricvision.service.Scarrera;
import com.example.biometricvision.service.Scurso;
import com.example.biometricvision.service.Smateria;
import com.example.biometricvision.service.Speriodo;
import com.example.biometricvision.service.Ssemestre;
import com.example.biometricvision.service.Susuario;
import com.example.biometricvision.utils.dateCurrent;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Component
public class initbase {

    @Autowired
    Carrera carrera;

    @Autowired
    Scarrera scarrera;

//    @Autowired
//    Scurso scursos;
//
//    @Autowired
//    Smateria smaterias;
//
//    @Autowired
//    Speriodo speriodo;
//
//    @Autowired
//    Ssemestre ssemestre;
//
//    @Autowired
//    Susuario susuario;

    static String[] nombresCarreras = {
        "Ingeniería de Software",
        "Medicina",
        "Derecho",
        "Arquitectura",
        "Psicología",
        "Ciencias de la Computación",
        "Biología",
        "Economía",
        "Ingeniería Civil",
        "Historia",
        "Matemáticas",
        "Química",
        "Administración de Empresas",
        "Diseño Gráfico",
        "Física",
        "Enfermería",
        "Comunicación",
        "Ingeniería Eléctrica",
        "Filosofía",
        "Geología",
        "Ciencias Políticas",
        "Ingeniería Mecánica",
        "Sociología",
        "Nutrición",
        "Educación",
        "Marketing",
        "Ingeniería Química",
        "Música",
        "Antropología"
    };

    //objects base de datos
    @PostConstruct
    @Autowired
    public void init() {
        System.out.println("holaaaaaaaaaaaaa");
        try {
            List<Carrera> lstcarrera = scarrera.all();
            if (lstcarrera.size()==0) {
                for (String nombresCarrera : nombresCarreras) {
                    carrera.setCarrera(nombresCarrera);
                    scarrera.guardar_actualizar(carrera);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}










