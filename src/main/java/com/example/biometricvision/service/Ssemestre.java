/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Semestre;
import com.example.biometricvision.repository.Isemestre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Ssemestre 
{
    @Autowired
    Isemestre isemestre;
    
    public Semestre guardar_actualizar(Semestre semestre)
    {
        return isemestre.save(semestre);
    }
    
    public void eliminar(Long id)
    {
        isemestre.deleteById(id);
    }
    
    public Semestre buscar_id(Long id)
    {
        return isemestre.findByIdsemestre(id);
    }
    
    
    public List<Semestre> all()
    {
        return isemestre.findAll();
    }

   
}
