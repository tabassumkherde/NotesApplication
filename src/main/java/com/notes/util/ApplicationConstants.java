package com.notes.util;

public class ApplicationConstants {
	public static final String NOTE_CRUD_APP= "Note Crud Application";
	public static final String NOTE_CRUD_APP_DESC="Spring Boot REST API for Note ";
	
	public static final String ADDED_NOTE_DESC="Added new %s Note.";
	public static final String UPDATED_NOTE_NOTEXIST_DESC="Note %s doesn't exist, Please provide correct details.";
	public static final String UPDATED_NOTE_DESC="Updated %s Note.";
	public static final String NOTE_ID_NOTEXIST="Note id : %s doesn't exist. Please provide correct id.";
	public static final String DELETE_ID="Deleted Note with id : %s ";
	
	//Validation Messages
	public static final String VALIDATION_NOTE_ID="Note id is required!";
	public static final String VALIDATION_USER_ID="Provide valid user id!";
	public static final String VALIDATION_UPDATE_NOTE_DATA="Provide valid details!";
	public static final String VALIDATION_NAME_EMPTY="Name should not be empty!";
	public static final String VALIDATION_AGE="Age is required!";
	public static final String VALIDATION_AGE_RANGE="Age must between {min} to {max}";
}
