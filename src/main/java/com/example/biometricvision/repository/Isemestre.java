/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.biometricvision.repository;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Profesor;
import com.example.biometricvision.models.Semestre;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public interface Isemestre extends JpaRepository<Semestre,Serializable>
{
    public Semestre findByIdsemestre(Long id);
}
