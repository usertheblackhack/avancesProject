/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Curso;
import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.repository.Icurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Scurso 
{
    @Autowired
    Icurso icurso;
    
    
    public Curso guardar_actualizar(Curso curso)
    {
        return icurso.save(curso);
    }
    
    public void eliminar(Long id)
    {
        icurso.deleteById(id);
    }
    
    public Curso buscar_id(Long id)
    {
        return icurso.findByIdcurso(id);
    }
    

    public List<Curso> all()
    {
        return icurso.findAll();
    }

}
