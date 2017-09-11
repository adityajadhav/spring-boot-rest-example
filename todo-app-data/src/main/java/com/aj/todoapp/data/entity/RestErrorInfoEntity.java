package com.aj.todoapp.data.entity;

public class RestErrorInfoEntity {

	public final String detail;
	public final String message;

	public RestErrorInfoEntity(Exception ex, String detail) {
		this.message = ex.getLocalizedMessage();
		this.detail = detail;
	}

}
