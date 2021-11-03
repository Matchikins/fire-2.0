package com.br.cefops.cefopsBD.domain.Exception;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResponseException implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ResponseException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}


	public ResponseException(String string, List<String> details2) {
		// TODO Auto-generated constructor stub
	}


	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	

}
