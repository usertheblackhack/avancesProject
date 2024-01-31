/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.controllers;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Usuario;
import com.example.biometricvision.service.Susuario;
import com.example.biometricvision.utils.Messages;
import com.example.biometricvision.utils.dateCurrent;
import com.example.biometricvision.utils.encryptString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/usuario")
public class CoUsuario 
{
    @Autowired 
    Susuario susuario;
    
    
    @PostMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Usuario> le=susuario.all();
            return new ResponseEntity<List<Usuario>>(le,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(Usuario usuario, @RequestParam(name="ide") Long ide)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(ide!=null && usuario.getContrasenia()!=null && usuario.getUsuario()!=null)
            {
                usuario.setFecha_creacion(dateCurrent.getDateCurrent());
                usuario.setFecha_modificacion(dateCurrent.getDateCurrent());
                Usuario usu=susuario.guardar(usuario);
                return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
            }else
            {
                response.put(Messages.ERROR_KEY, Messages.error_datos_incompletos);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
            }  
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(Usuario usuario, @RequestParam(name="ide") Long ide)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(ide!=null && usuario.getUsuario()!=null)
            {
                Usuario est= susuario.buscar_id(usuario.getIdusuario());
                est.setUsuario(usuario.getUsuario());
              
                Usuario usu=null;
                if(usuario.getContrasenia()!=null)
                {
                    est.setContrasenia(usuario.getContrasenia());
                    usu=susuario.actualizar(est,false);
                }else
                {
                    est.setContrasenia(usuario.getContrasenia());
                    usu=susuario.actualizar(est,true);
                }
                return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.error_datos_incompletos);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
            }  
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    //porciacaso
    @PostMapping("/buscarid")
    public ResponseEntity<?> buscar_id(@RequestParam(name="id") Long id)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(id!=null)
            {
                encryptString cry=new encryptString();
                Usuario est=  susuario.buscar_id(Long.parseLong(cry.textDecryptor(id.toString())));
                Map<String,Object> user=new HashMap();
                user.put("id", cry.textEncryptor(est.getIdusuario().toString()));
                user.put("user", est.getUsuario());
                user.put("admin", est.getAdmin());
                user.put("email", est.getIdestudiante().getCorreo());
                return new ResponseEntity<Map<String,Object>>(user,HttpStatus.OK);
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.error_datos_incompletos);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
            }  
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/inicio_sesion")
    public ResponseEntity<?> iniciar_sesion(@RequestParam(name="usuario") String usuario, @RequestParam(name="contrasenia") String contrasenia)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(usuario!="" && contrasenia!="")
            {
                encryptString cry=new encryptString();
                Usuario est=  susuario.buscar_usuario(usuario);
                if(est!=null)
                {
                    if(est.getUsuario().equals(usuario) && cry.encriptPassword(contrasenia).equals(est.getContrasenia()))
                    {
                        Map<String,Map<String,Object>> log=new HashMap();
                        
                        Map<String,Object> user=new HashMap();
                        user.put("id", cry.textEncryptor(est.getIdusuario().toString()));
                        user.put("user", est.getUsuario());
                        user.put("admin", est.getAdmin());
                        user.put("email", est.getIdestudiante().getCorreo());
                        
                        log.put(Messages.ACCEPT, user);
                        return new ResponseEntity<Map<String,Map<String,Object>>>(log,HttpStatus.OK);
                    }
                    else
                    {
                        response.put(Messages.ACCEPT, Messages.contrasenia_incorrecta);
                        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);  
                    }
                }else
                {
                   response.put(Messages.ACCEPT, Messages.usuario_no_existe);
                   return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);  
                }
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.error_datos_incompletos);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
            }  
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    
}
