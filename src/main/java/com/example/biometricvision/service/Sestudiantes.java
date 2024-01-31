/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.repository.Iestudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Sestudiantes 
{
    @Autowired
    Iestudiante iestudiante;
    
    
    public Estudiante guardar_actualizar(Estudiante estudiante)
    {
        return iestudiante.save(estudiante);
    }
    
    public void eliminar(Long id)
    {
        iestudiante.deleteById(id);
    }
    
    public Estudiante buscar_id(Long id)
    {
        return iestudiante.findByIdestudiante(id);
    }
    
    public Estudiante buscar_cedula(String cedula)
    {
        return iestudiante.findByCedula(cedula);
    }
    
    
    public List<Estudiante> all()
    {
        return iestudiante.findAll();
    }
    
}
