package dev.aji.productservice.exceptions;

public class NotFoundException extends  Exception{
    public  NotFoundException(String message){
        super(message);
    }
}