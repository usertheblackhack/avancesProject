/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Asistencia;
import com.example.biometricvision.models.Curso;
import com.example.biometricvision.repository.Iasistencia;
import com.example.biometricvision.repository.Icurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Sasistencia 
{
    @Autowired
    Iasistencia iasistencia;
    
    
    public Asistencia guardar_actualizar(Asistencia curso)
    {
        return iasistencia.save(curso);
    }
    
    public void eliminar(Long id)
    {
        iasistencia.deleteById(id);
    }
    
    public Asistencia buscar_id(Long id)
    {
        return iasistencia.findByIdasistencia(id);
    }
    

    public List<Asistencia> all()
    {
        return iasistencia.findAll();
    }

}
