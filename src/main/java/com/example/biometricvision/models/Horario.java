/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author USUARIO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="horario",uniqueConstraints = {
   @UniqueConstraint(name = "Uqhorario", columnNames = {"idcurso", "idmateria","idprofesor"})})
public class Horario implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idhorario;
    
    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false, unique = false)
    Curso idcurso;
    
    @ManyToOne
    @JoinColumn(name = "idmateria", nullable = false, unique = false)
    Materia idmateria;
    
    @ManyToOne
    @JoinColumn(name = "idprofesor", nullable = false, unique = false)
    Profesor idprofesor;
    
    @Column(name = "hora", nullable = false, unique = false)
    Integer hora;
    
    @Column(name = "minuto", nullable = false, unique = false)
    Integer minuto;
    
    @Column(name = "dia", nullable = false, unique = false)
    Integer dia;
    
    @Column(name = "fecha_creacion", nullable = false, unique = false)
    LocalDateTime  fecha_creacion;
    
    
    @Column(name = "fecha_modificacion", nullable = false, unique = false)
    LocalDateTime fecha_modificacion;
    
    
    @OneToMany(mappedBy = "idhorario")
    private List<Matriculacion> lstMatriculacion;
    
    
    @OneToMany(mappedBy = "idhorario")
    private List<Asistencia> lstAsistencia;
    
    
    
    
    
    @PrePersist 
    public  void  onPrePersist () { 
        this.fecha_creacion=LocalDateTime.now(); 
        this.fecha_modificacion=LocalDateTime.now(); 
    } 

    @PreUpdate 
    public  void  onPreUpdate () { 
        this.fecha_modificacion=LocalDateTime.now(); 
    } 
    
}
