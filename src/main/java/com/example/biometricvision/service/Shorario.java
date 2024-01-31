/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Horario;
import com.example.biometricvision.models.Materia;
import com.example.biometricvision.repository.Ihorario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Shorario 
{
    @Autowired
    Ihorario ihorario;
    
    public Horario guardar_actualizar(Horario horario)
    {
        return ihorario.save(horario);
    }
    
    public void eliminar(Long id)
    {
        ihorario.deleteById(id);
    }
    
    public Horario buscar_id(Long id)
    {
        return ihorario.findByIdhorario(id);
    }
    

    public List<Horario> all()
    {
        return ihorario.findAll();
    }
    
    
}
