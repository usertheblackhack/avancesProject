/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.biometricvision.repository;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Horario;
import com.example.biometricvision.models.Materia;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public interface Imateria  extends JpaRepository<Materia,Serializable>
{
    public Materia findByIdmateria(Long id);
    public List<Materia> findByNombremateria(String cedula);
}
