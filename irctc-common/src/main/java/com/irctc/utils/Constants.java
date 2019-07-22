package com.irctc.utils;

public class Constants {

	public static final String STATUS = "status";
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_ERROR = "error";
	public static final String MESSAGE = "message";
	
	public static final String OPERATION_CREATE = "/create";
	public static final String OPERATION_READ = "/read";
	public static final String OPERATION_UPDATE = "/update";
	public static final String OPERATION_DELETE = "/delete";
	public static final String OPERATION_LIST = "/list";
	
	public static final String IRCTC_BASE_URL = "/irctc-api";
	public static final String IRCTC_USER = IRCTC_BASE_URL + "/user";
	public static final String IRCTC_TRAIN = IRCTC_BASE_URL + "/train";
	public static final String IRCTC_STATION = IRCTC_BASE_URL + "/station";
	public static final String IRCTC_SCHEDULE = IRCTC_BASE_URL + "/schedule";
	public static final String IRCTC_PASSENGER = IRCTC_BASE_URL + "/passenger";
}
