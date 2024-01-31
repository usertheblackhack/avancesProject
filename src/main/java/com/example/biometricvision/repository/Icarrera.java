/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.biometricvision.repository;

import com.example.biometricvision.models.Carrera;
import com.example.biometricvision.models.Curso;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public interface Icarrera extends JpaRepository<Carrera,Serializable>
{
    public Carrera findByIdcarrera(Long id);
}
