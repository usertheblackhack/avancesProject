/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Asistencia;
import com.example.biometricvision.models.Carrera;
import com.example.biometricvision.repository.Iasistencia;
import com.example.biometricvision.repository.Icarrera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Scarrera 
{
    @Autowired
    Icarrera icarrera;
    
    
    public Carrera guardar_actualizar(Carrera carrera)
    {
        return icarrera.save(carrera);
    }
    
    public void eliminar(Long id)
    {
        icarrera.deleteById(id);
    }
    
    public Carrera buscar_id(Long id)
    {
        return icarrera.findByIdcarrera(id);
    }
    

    public List<Carrera> all()
    {
        return icarrera.findAll();
    }

}
