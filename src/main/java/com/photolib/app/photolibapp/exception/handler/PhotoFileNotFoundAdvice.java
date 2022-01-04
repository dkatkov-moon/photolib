package com.photolib.app.photolibapp.exception.handler;

import com.photolib.app.photolibapp.exception.PhotoFileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PhotoFileNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PhotoFileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String photoFileNotFoundHandler(PhotoFileNotFoundException exception) {
        return exception.getMessage();
    }
}
