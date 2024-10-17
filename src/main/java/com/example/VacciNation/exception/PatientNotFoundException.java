package com.example.VacciNation.exception;

public class PatientNotFoundException extends RuntimeException{
    public  PatientNotFoundException(String message){
        super(message);
    }
}
