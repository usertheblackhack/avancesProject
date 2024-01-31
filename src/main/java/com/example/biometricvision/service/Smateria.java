/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Curso;
import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Materia;
import com.example.biometricvision.repository.Imateria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Smateria {
    
    @Autowired
    Imateria imateria;
    
    
    public Materia guardar_actualizar(Materia materia)
    {
        return imateria.save(materia);
    }
    
    public void eliminar(Long id)
    {
        imateria.deleteById(id);
    }
    
    public Materia buscar_id(Long id)
    {
        return imateria.findByIdmateria(id);
    }
    
    public List<Materia> buscar_nombre_materia(String nombremateria)
    {
        return imateria.findByNombremateria(nombremateria);
    }
    
    public List<Materia> all()
    {
        return imateria.findAll();
    }
    
}
