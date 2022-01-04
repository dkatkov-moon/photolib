package com.photolib.app.photolibapp.exception;

public class PhotoFileNotFoundException extends RuntimeException{
    public PhotoFileNotFoundException(Long photoFileId) {
        super("Photo file not found with id: " + photoFileId);
    }
}
