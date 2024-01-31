/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class dateCurrent 
{
    public static LocalDateTime getDateCurrent() throws ParseException
    {
        System.out.println( LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        LocalDateTime dateTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return dateTime;
    }
    
    public static LocalTime getHourCurrent() throws ParseException
    {
        System.out.println( LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
        LocalTime Time = LocalTime.parse(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
        return Time;
    }
    
}
